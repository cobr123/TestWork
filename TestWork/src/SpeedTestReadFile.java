import java.util.List;


public class SpeedTestReadFile {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	    Stopwatch stopwatch = new Stopwatch();
	    String testFile = "TestData\\3.txt";

	    stopwatch.start();

	    //do stuff
	    ReadFileByPattern bp1 = new ReadFileByPattern(testFile);
		List<Pair> list1 = bp1.call();

	    stopwatch.stop();
	    System.out.println("The reading for ReadFileByPattern is: " + stopwatch + ". size = " + list1.size());

	    //----------------------------
	    stopwatch.start();

	    //do stuff
	    ReadFileByScanner bs1 = new ReadFileByScanner(testFile);
		List<Pair> list2 = bs1.call();

	    stopwatch.stop();
	    System.out.println("The reading for ReadFileByScanner is: " + stopwatch + ". size = " + list2.size());
	    
	    //----------------------------
	    stopwatch.start();

	    //do stuff
	    ReadFileByPattern bp2 = new ReadFileByPattern(testFile);
		List<Pair> list3 = bp2.call();

	    stopwatch.stop();
	    System.out.println("The reading for ReadFileByPattern is: " + stopwatch + ". size = " + list3.size());

	    //----------------------------
	    stopwatch.start();

	    //do stuff
	    ReadFileByScanner bs2 = new ReadFileByScanner(testFile);
		List<Pair> list4 = bs2.call();

	    stopwatch.stop();
	    System.out.println("The reading for ReadFileByScanner is: " + stopwatch + ". size = " + list4.size());
	}

}
