package ContentClasses;

import java.util.List;

import BaseClasses.GitObjectBlob;
import BaseClasses.GitObjectTree;

public class GitObjectTreeContent {
	// A tree is a simple object that has a bunch of pointers to blobs
	// and other trees - it generally represents the contents of a directory
	// or subdirectory.

	final private List<GitObjectBlob> blobs;
	final private List<GitObjectTree> trees;

	public GitObjectTreeContent(List<GitObjectBlob> blobs, List<GitObjectTree> trees) {
		super();
		this.blobs = blobs;
		this.trees = trees;
	}

	public List<GitObjectBlob> getBlobs() {
		return blobs;
	}

	public List<GitObjectTree> getTrees() {
		return trees;
	}

}
