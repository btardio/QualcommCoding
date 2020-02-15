package BaseClasses;

import ContentClasses.GitObjectCommitContent;

public class GitObjectCommit extends GitObjectBase {

	public GitObjectCommit(int size, Object content) {
		super(GitObjectEnum.COMMIT, size, content);

		if (!(content instanceof GitObjectCommitContent)) {
			throw new ClassCastException("Content must be an instance of " + GitObjectCommitContent.class.getName());
		}

	}

}
