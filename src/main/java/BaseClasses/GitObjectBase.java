package BaseClasses;

public abstract class GitObjectBase implements GitObjectInterface {

	final GitObjectEnum type;
	final int size;
	final Object content;

	public GitObjectBase(GitObjectEnum type, int size, Object content) {

		if (content == null) {
			throw new NullPointerException("Content is null.");
		}

		if (size < 0) {
			throw new IllegalStateException("Size is less than 0.");
		}

		this.type = type;
		this.size = size;
		this.content = content;
	}

	public GitObjectEnum getType() {
		return type;
	}

	public int getSize() {
		return size;
	}

	public Object getContent() {
		return content;
	}

	@Override
	public int hashCode() throws NullPointerException {

		return this.content.hashCode();
	}

}
