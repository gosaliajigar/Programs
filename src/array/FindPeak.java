package array;

import java.util.Arrays;

/**
 * Find peak element of the peak in an array using Binary Search.
 * 
 * Time Complexity : O(logn)
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class FindPeak {

	/**
	 * find peak using binary search.
	 * 
	 * @param a
	 * @param left
	 * @param right
	 * @param n
	 * @return
	 */
	private static int peak(int[] a, int left, int right, int n) {
		if (left <= right) {
			int mid = left + ((right - left) / 2);
			// Compare middle element with its neighbors (if neighbors exist)
			if ((mid == 0 || a[mid - 1] < a[mid])
					&& (mid == n - 1 || a[mid + 1] < a[mid])) {
				return mid;
				// If middle element is not peak and its left neighbor is
				// greater than it, then left half must have a peak element
			} else if (mid > 0 && a[mid - 1] > a[mid]) {
				return peak(a, left, mid - 1, n);
				// If middle element is not peak and its right neighbor is
				// greater than it, then right half must have a peak element
			} else {
				return peak(a, mid + 1, right, n);
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 20, 4, 1, 0 };
		System.out.println("Peak Index" 
								+ Arrays.toString(A) 
								+ " : " 
								+ peak(A, 0, A.length - 1, A.length));
	}
}
