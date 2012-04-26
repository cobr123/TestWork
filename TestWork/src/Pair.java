public class Pair {
	private final int val1;
	private final int val2;
	private int fHashCode;

	Pair(int val1, int val2) {
		this.val1 = val1;
		this.val2 = val2;
	}

	public int getVal2() {
		return val2;
	}

	public int getVal1() {
		return val1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pair))
			return false;
		Pair p = (Pair) obj;
		return p.getVal1() == val1 && p.getVal2() == val2;
	}

	@Override
	public int hashCode() {
		// this style of lazy initialization is
		// suitable only if the object is immutable
		if (fHashCode == 0) {
			int result = HashCodeUtil.SEED;
			result = HashCodeUtil.hash(result, val1);
			result = HashCodeUtil.hash(result, val2);
			fHashCode = result;
		}
		return fHashCode;
	}

	@Override
	public String toString() {
		return String.valueOf(val1) + '\t' + String.valueOf(val2);
	}
}
