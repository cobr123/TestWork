import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ReadFileByScanner implements Callable<List<Pair>>{
	final private String fileName;

	ReadFileByScanner(String fileName){
		this.fileName = fileName;
	}
	
	protected Pair processLine(String aLine) {
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("\t");
		int val1 = 0;
		int val2 = 0;
		
		if (scanner.hasNext()) {
			val1 = Integer.parseInt(scanner.next());
			val2 = Integer.parseInt(scanner.next());
			//System.out.println(val1 + "	" + val2);
		}
		return new Pair(val1, val2);
	}

	@Override
	public List<Pair> call() throws Exception {
		Scanner scanner = new Scanner(new FileInputStream(fileName));
		List<Pair> list = new ArrayList<Pair>();
		int i = 0;
		try {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (i > 1) {
					list.add(processLine(line));
				}
				++i;
			}
		} finally {
			scanner.close();
		}
		return list;
	}

}
