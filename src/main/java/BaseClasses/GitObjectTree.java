package BaseClasses;

import ContentClasses.GitObjectTreeContent;

public class GitObjectTree extends GitObjectBase {

	public GitObjectTree(int size, Object content) {
		super(GitObjectEnum.TREE, size, content);

		if (!(content instanceof GitObjectTreeContent)) {
			throw new ClassCastException("Content must be an instance of " + GitObjectTreeContent.class.getName());
		}

	}

}
