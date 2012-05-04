import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class ReadFileByPattern implements Callable<List<Pair>> {
	final private String fileName;
	private static final Pattern COMMA = Pattern.compile("\t");

	ReadFileByPattern(String fileName) {
		this.fileName = fileName;
	}

	protected Pair processLine(String aLine) {
		int i = 0;
		int val[] = new int[2];

		for (String token : COMMA.split(aLine)) {
			try {
				val[i] = Integer.parseInt(token);
			} catch (NumberFormatException ex) {
				System.err.println(token + " is not a number");
			}
			++i;
		}
		return new Pair(val[0], val[1]);
	}

	@Override
	public List<Pair> call() throws Exception {
		List<Pair> list = new ArrayList<Pair>();
		BufferedReader input = new BufferedReader(new FileReader(fileName));
		try {
			String line = null; // not declared within while loop
			/*
			 * readLine is a bit quirky : it returns the content of a line MINUS
			 * the newline. it returns null only for the END of the stream. it
			 * returns an empty String if two newlines appear in a row.
			 */
			int i = 0;
			while ((line = input.readLine()) != null) {
				if (i > 1) {
					list.add(processLine(line));
				}
				++i;
			}
		} finally {
			input.close();
		}
		return list;
	}

}
