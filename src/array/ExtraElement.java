package array;

/**
 * Find the index of extra element from two sorted arrays.<br>
 * 1. Brute Force (using 2 pointers) is O(m+n)<br>
 * 2. Binary Search O(logn)<br>
 * <br>
 * @author "Jigar Gosalia"
 *
 */
public class ExtraElement {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] B = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

		if (A.length == B.length) {
			System.out.println("Same Length so no extra element");
		} else {
			int min = Math.min(A.length, B.length);
			System.out.println(indexOfExtraElement(A, B, min-1));
		}
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
		// size is length of minimum array
		// index is set to last element of bigger array
		int left = 0, right = size, index = size+1;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			if (a[mid] == b[mid]) {
				// extra element in later half
				left = mid + 1;
			} else {
				// extra element in first half
				index = mid;
				right = mid - 1;
			}
		}
		return index;
	}
}
