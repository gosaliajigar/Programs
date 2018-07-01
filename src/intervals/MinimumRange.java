package intervals;

/**
 * Minimum range of all sorted arrays
 * 
 * @author Jigar Gosalia
 *
 */
public class MinimumRange {

	public static void main(String[] args) {
		int[] a = { 3, 6, 8, 10, 15 }, b = { 1, 5, 12 }, c = { 4, 8, 15, 16 }, d = { 2, 6 };
		int start = getMax(a[0], b[0], c[0], d[0]);
		int end = getMin(a[a.length - 1], b[b.length - 1], c[c.length - 1], d[d.length - 1]);
		System.out.println(start + " - " + end);
	}

	private static int getMax(int i, int j, int k, int l) {
		return (Math.max(Math.max(i, j), Math.max(k, l)));
	}

	private static int getMin(int i, int j, int k, int l) {
		return (Math.min(Math.min(i, j), Math.min(k, l)));
	}
}
