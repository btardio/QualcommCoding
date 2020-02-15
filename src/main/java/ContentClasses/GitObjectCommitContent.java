package ContentClasses;

import java.util.List;

import BaseClasses.GitObjectCommit;
import BaseClasses.GitObjectTree;

public class GitObjectCommitContent {

//	As you can see, a commit is defined by:
//
//		     a tree: The SHA1 name of a tree object, representing
//          	     the contents of a directory at a certain point in time.
//		  parent(s): The SHA1 name of some number of commits which represent
//                   the immediately previous step(s) in the history of the 
//                   project. The example above has one parent; merge commits
//                   may have more than one. A commit with no parents is called
//                   a "root" commit, and represents the initial revision of a 
//                   project. Each project must have at least one root. A 
//                   project can also have multiple roots, though that isn't 
//                   common (or necessarily a good idea).
//		  an author: The name of the person responsible for this change, 
//                   together with its date.
//		a committer: The name of the person who actually created the commit,
//                   with the date it was done. This may be different from 
//                   the author; for example, if the author wrote a patch and 
//                   emailed it to another person who used the patch to create
//                   the commit.
//		  a comment: describing this commit.

	private final GitObjectTree tree;
	private final List<GitObjectCommit> parents;
	private final String author;
	private final String commiter;
	private final String comment;

	public GitObjectCommitContent(GitObjectTree tree, List<GitObjectCommit> parents, String author, String commiter,
			String comment) {
		super();
		this.tree = tree;
		this.parents = parents;
		this.author = author;
		this.commiter = commiter;
		this.comment = comment;
	}

	public GitObjectTree getTree() {
		return tree;
	}

	public List<GitObjectCommit> getParents() {
		return parents;
	}

	public String getAuthor() {
		return author;
	}

	public String getCommiter() {
		return commiter;
	}

	public String getComment() {
		return comment;
	}
}
