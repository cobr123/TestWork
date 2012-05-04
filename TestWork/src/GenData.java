import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GenData {

	public static void main(String[] args) throws IOException {

		StringBuilder contents = new StringBuilder();
		contents.append("i");
		contents.append('\t');
		contents.append("j\n");
		contents.append("-----\n");
		for (int i = 1; i < 1000; ++i) {
			for (int j = 1; j < 1000; ++j) {
				contents.append(i);
				contents.append('\t');
				contents.append(j);
				contents.append('\n');
			}
		}

		// use buffering
		Writer output = new BufferedWriter(new FileWriter("TestData\\3.txt"));
		try {
			// FileWriter always assumes default encoding is OK!
			output.write(contents.toString());
		} finally {
			output.close();
		}
	}
}
