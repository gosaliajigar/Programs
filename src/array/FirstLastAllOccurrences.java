package array;

/**
 * Find first, last and all occurrence of an integer in an array using Binary Search.
 * 
 * Time Complexity : O(logn)
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class FirstLastAllOccurrences {

	/**
	 * Search first occurrence using binary search until either you reach start
	 * of array (mid == 0) or previous element is less than search element.
	 * 
	 * @param a
	 * @param left
	 * @param right
	 * @param x
	 * @return
	 */
	private static int firstOccurrence(int[] a, int left, int right, int x, int n) {
		if (left <= right) {
			int mid = ((left + right) / 2);
			if (a[mid] == x && (mid == 0 || a[mid - 1] < x)) {
				return mid;
			} else if (a[mid] < x) {
				return firstOccurrence(a, (mid + 1), right, x, n);
			} else {
				return firstOccurrence(a, left, (mid - 1), x, n);
			}
		}
		return -1;
	}

	/**
	 * Search last occurrence using binary search until either you reach end of
	 * array (mid == n-1) or next element is greater than search element.
	 * 
	 * @param a
	 * @param left
	 * @param right
	 * @param x
	 * @return
	 */
	private static int lastOccurrence(int[] a, int left, int right, int x, int n) {
		if (left <= right) {
			int mid = ((left + right) / 2);
			if (a[mid] == x && (mid == n - 1 || a[mid + 1] > x)) {
				return mid;
			} else if (a[mid] > x) {
				return lastOccurrence(a, left, mid - 1, x, n);
			} else {
				return lastOccurrence(a, mid + 1, right, x, n);
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		int find = 2;
		int first = firstOccurrence(input, 0, input.length - 1, find, input.length);
		int last = lastOccurrence(input, 0, input.length - 1, find, input.length);
		int all = last - first + 1;
		System.out.printf("First Occurrence(%d) : %d\n", find, first);
		System.out.printf("Last Occurrence(%d)  : %d\n", find, last);
		System.out.printf("All Occurrences(%d)  : %d\n", find, all);
	}

}
