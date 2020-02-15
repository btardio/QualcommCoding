package BaseClasses;

import ContentClasses.GitObjectTagContent;

public class GitObjectTag extends GitObjectBase {

	public GitObjectTag(int size, Object content) {
		super(GitObjectEnum.TAG, size, content);

		if (!(content instanceof GitObjectTagContent)) {
			throw new ClassCastException("Content must be an instance of " + GitObjectTagContent.class.getName());
		}

	}

}
