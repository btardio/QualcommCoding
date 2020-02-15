
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import BaseClasses.GitObjectBase;
import BaseClasses.GitObjectBlob;
import BaseClasses.GitObjectCommit;
import BaseClasses.GitObjectEnum;
import BaseClasses.GitObjectTag;
import BaseClasses.GitObjectTree;
import ContentClasses.GitObjectBlobContent;
import ContentClasses.GitObjectCommitContent;
import ContentClasses.GitObjectTagContent;
import ContentClasses.GitObjectTreeContent;

public class GitObjectTests {

	@Test
	public void TestGitObjectBase() {
		try {
			GitObjectBase gob = new GitObjectBlob(100, null);
		} catch (NullPointerException e) {
		}

		try {
			GitObjectBase gob0 = new GitObjectBlob(-1, new GitObjectBlobContent(new File("testfileblank")));
		} catch (IllegalStateException i) {
		}

		GitObjectBase obj = new GitObjectBlob(100, new GitObjectBlobContent(new File("testfileblank")));

		assertEquals(obj.getSize(), 100);
		assertEquals(obj.getType(), GitObjectEnum.BLOB);

		assertNotEquals(obj.hashCode(), null);

	}

	@Test
	public void TestGitObjectBlob() throws IOException {

		File f = new File("testfileblank");

		GitObjectBase obj = new GitObjectBlob(100, new GitObjectBlobContent(f));

		((GitObjectBlobContent) obj.getContent()).asString();

		((GitObjectBlobContent) obj.getContent()).open();

		assertTrue(((GitObjectBlobContent) obj.getContent()).show().iterator().next().equals("test file blank"));

		((GitObjectBlobContent) obj.getContent()).close();
	}

	@Test
	public void TestGitObjectBlobFail() throws IOException {

		File f = new File("GitObjectBase.java", "r");

		try {
			GitObjectBase obj = new GitObjectBlob(100, new GitObjectTagContent(null, null, null, null, null));
		} catch (ClassCastException e) {
		}

		GitObjectBase obj = new GitObjectBlob(100, new GitObjectBlobContent(null));

		try {
			((GitObjectBlobContent) obj.getContent()).show();
		} catch (IOException e) {
		}
	}

	@Test
	public void TestGitObjectCommit() throws IOException {

		GitObjectBase obj = new GitObjectCommit(100,
				new GitObjectCommitContent(null, null, "author a", "commiter b", "comment c"));

		assertEquals(((GitObjectCommitContent) obj.getContent()).getTree(), null);
		assertEquals(((GitObjectCommitContent) obj.getContent()).getParents(), null);
		assertTrue(((GitObjectCommitContent) obj.getContent()).getAuthor().equals("author a"));
		assertTrue(((GitObjectCommitContent) obj.getContent()).getCommiter().equals("commiter b"));
		assertTrue(((GitObjectCommitContent) obj.getContent()).getComment().equals("comment c"));
	}

	@Test
	public void TestGitObjectCommitFail() throws IOException {
		try {
			GitObjectBase obj = new GitObjectCommit(100, new GitObjectBlobContent(null));
		} catch (ClassCastException e) {
		}
	}

	@Test
	public void TestGitObjectTag() throws IOException {

		GitObjectBase obj = new GitObjectTag(100,
				new GitObjectTagContent("object name", GitObjectEnum.TREE, "tag a", "tagger b", "message c"));

		assertTrue(((GitObjectTagContent) obj.getContent()).getObject().equals("object name"));
		assertEquals(((GitObjectTagContent) obj.getContent()).getType(), GitObjectEnum.TREE);
		assertTrue(((GitObjectTagContent) obj.getContent()).getTag().equals("tag a"));
		assertTrue(((GitObjectTagContent) obj.getContent()).getTagger().equals("tagger b"));
		assertTrue(((GitObjectTagContent) obj.getContent()).getMessage().equals("message c"));
	}

	@Test
	public void TestGitObjectTagFail() throws IOException {
		try {
			GitObjectBase obj = new GitObjectTag(100, new GitObjectBlobContent(null));
		} catch (ClassCastException e) {
		}
	}

	@Test
	public void TestGitObjectTree() throws IOException {

		GitObjectBase obj = new GitObjectTree(100, new GitObjectTreeContent(null, null));

		assertEquals(((GitObjectTreeContent) obj.getContent()).getBlobs(), null);
		assertEquals(((GitObjectTreeContent) obj.getContent()).getTrees(), null);
	}

	@Test
	public void TestGitObjectTreeFail() throws IOException {
		try {
			GitObjectBase obj = new GitObjectTree(100, new GitObjectBlobContent(null));
		} catch (ClassCastException e) {
		}
	}

}
