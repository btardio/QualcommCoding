package ContentClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class GitObjectBlobContent {

	// A blob generally stores the contents of a file.

	final private File file;
	private BufferedReader reader = null;

	public GitObjectBlobContent(File f) {
		this.file = f;
	}

	public void open() throws FileNotFoundException {
		this.reader = new BufferedReader(new FileReader(file));
	}

	public void close() throws IOException {
		reader.close();
		reader = null;
	}

	public Stream<String> show() throws IOException {
		if (reader == null) {
			throw new IOException("File not open or constructed with null file.");
		}
		return reader.lines();
	}

	public String asString() throws IOException {
		StringBuilder fileString = new StringBuilder();
		String line = "";
		this.open();
		while ((line = this.reader.readLine()) != null) {
			fileString.append(line);
		}
		this.close();
		return fileString.toString();
	}
}
