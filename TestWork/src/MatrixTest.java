import java.util.concurrent.ExecutionException;



public class MatrixTest {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

	    if (args.length!=1){
	      System.out.println(
	        "Proper Usage: java MatrixTest Directory");
	      System.exit(0);
	    }
	    
		Matrix m = new Matrix(args[0]);
		m.init();
		m.dump();
		System.out.println('\n' + "(1,1) = " + m.get(1,1));
		System.out.println("(2,2) = " + m.get(2,2));
	}

}
