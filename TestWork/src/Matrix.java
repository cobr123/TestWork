import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class Matrix {
	private final String dir;
	private final int MAX_THREADS = 10;

	private Map<Pair, Integer> freq;
	
	private Set<Integer> rows;
	private Set<Integer> cols;

	Matrix(String dir) {
		this.dir = dir;
	}
	public String get(int col, int row){
		Pair p = new Pair(row, col);
		String count = freq.containsKey(p) ? freq.get(p).toString() : "NaN";
		
		return count;
	}

	public void init() throws InterruptedException, ExecutionException {
		File actual = new File(dir);

		ArrayList<Pair> list = new ArrayList<Pair>();

		List<Future<List<Pair>>> futures = new ArrayList<Future<List<Pair>>>();

		final ExecutorService service = Executors
				.newFixedThreadPool(MAX_THREADS);

		try {

			for (File f : actual.listFiles()) {
				futures.add(service.submit(new ReadFileByScanner(f.getPath())));
			}

			for (Future<List<Pair>> future : futures) {
				list.addAll(future.get());
			}

		} finally {
			service.shutdown();
		}

		freq = new HashMap<Pair, Integer>();
		rows = new HashSet<Integer>();
		cols = new HashSet<Integer>();

		for (Pair p : list) {
			rows.add(p.getVal1());
			cols.add(p.getVal2());
			int count = freq.containsKey(p) ? freq.get(p) : 0;
			freq.put(p, count + 1);
		}
//		for (Pair key : freq.keySet()) {
//			System.out.println(key.toString() + ":" + freq.get(key));
//		}
	}

	public void dump() {
		for (Integer r : rows) {
			for (Integer c : cols) {
//				Pair p = new Pair(r, c);
//				String count = freq.containsKey(p) ? freq.get(p).toString() : "NaN";
				System.out.print(get(c, r) + '\t');
			}
			System.out.print('\n');
		}
	}
}
