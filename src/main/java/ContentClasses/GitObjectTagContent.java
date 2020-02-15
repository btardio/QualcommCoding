package ContentClasses;

import BaseClasses.GitObjectEnum;

public class GitObjectTagContent {

	// A tag object contains an object name (called simply 'object'), object
	// type, tag name, the name of the person ("tagger") who created the tag,
	// and a message

	final private String object;
	final private GitObjectEnum type;
	final private String tag;
	final private String tagger;
	final private String message;

	public GitObjectTagContent(String object, GitObjectEnum type, String tag, String tagger, String message) {
		super();
		this.object = object;
		this.type = type;
		this.tag = tag;
		this.tagger = tagger;
		this.message = message;
	}

	public String getObject() {
		return object;
	}

	public GitObjectEnum getType() {
		return type;
	}

	public String getTag() {
		return tag;
	}

	public String getTagger() {
		return tagger;
	}

	public String getMessage() {
		return message;
	}
}
