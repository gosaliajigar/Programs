package array;

/**
 * Find the index of extra element from two sorted arrays.<br>
 * 1. Brute Force is O(m+n)<br>
 * 2. Binary Search O(logn)<br>
 * <br>
 * @author "Jigar Gosalia"
 *
 */
public class ExtraElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] B = {1, 2, 3, 4, 5, 0, 6, 7, 8, 9};

		int min = ((A.length < B.length) ? A.length : B.length);
		System.out.println(indexOfExtraElement(A, B, min));
	}

	/**
	 * Use binary search to find the index of extra element from 2 sorted arrays.
	 * 
	 * @param a
	 * @param b
	 * @param size
	 * @return
	 */
	private static int indexOfExtraElement(int[] a, int[] b, int size) {
		int left = 0, right = size, index = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (a[mid] == b[mid]) {
				left = mid + 1;
			} else {
				index = mid;
				right = mid - 1;
			}
		}
		return index;
	}
}
