package array;

/**
 * Maximum sum of elements which are not adjacent.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MaxNonAdjacentSum {

	private static int maxNonAdjacentSum(int[] a) {
		// current max including previous
		int include = a[0];
		int exclude = 0, excludeNew = 0;

		for (int i = 1; i < a.length; i++) {
			// current max excluding i
			excludeNew = Math.max(include, exclude);
			// current max including i
			include = exclude + a[i];
			// current max excluding previous
			exclude = excludeNew;
		}
		return Math.max(include, exclude);
	}

	public static void main(String[] args) {
		System.out.println(maxNonAdjacentSum(new int[] {5, 5, 10, 40, 50, 35}));
		System.out.println(maxNonAdjacentSum(new int[] {-5, -5, -10, -40, -50, -35}));
	}
}
