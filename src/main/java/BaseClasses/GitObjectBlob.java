package BaseClasses;

import ContentClasses.GitObjectBlobContent;

public class GitObjectBlob extends GitObjectBase {

	public GitObjectBlob(int size, Object content) {
		super(GitObjectEnum.BLOB, size, content);

		if (!(content instanceof GitObjectBlobContent)) {
			throw new ClassCastException("Content must be an instance of " + GitObjectBlobContent.class.getName());
		}
	}

}
