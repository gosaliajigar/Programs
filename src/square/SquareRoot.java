package square;

/**
 * 
 * Tail recursive approach to resolve this problem.
 * 
 * This algorithm is based on a binary search and implemented using a tail
 * recursive approach.
 * 
 * space O(1) and time (log n)
 * 
 *
 * @author Jigar Gosalia
 *
 */
public class SquareRoot {

	private static final double TOLERANCE = 0.000000001;

	public static void main(String[] args) {
		System.out.println(squareRoot(4));
		System.out.println(squareRoot(9));
		System.out.println(squareRoot(11));
		System.out.println(squareRoot(16));
		System.out.println(squareRoot(17));
		System.out.println(squareRoot(25));
		System.out.println(squareRoot(26));
	}

	public static double squareRoot(int number) {
		return sqrtRecursive(number, 0, number);
	}

	private static double sqrtRecursive(int n, double low, double high) {
		double mid = low + ((high-low) / 2);
		double diff = mid * mid - n;
		// go left
		if (diff > TOLERANCE) return sqrtRecursive(n, low, mid);
		// go right
		if (-diff > TOLERANCE) return sqrtRecursive(n, mid, high);
		return mid;
	}
}
