package array;

import java.util.Arrays;

/**
 * Merge sorted array in place by re-arranging elements in same arrays.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MergeSortedArraysByRearragingElements {

	public static void main(String[] args) {
		int[] A = {1, 5, 9, 10, 15, 20};
		int[] B = {2, 3, 8, 21};
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));
		System.out.println("C: " + Arrays.toString(mergeInNewArray(A, B)));
		mergeInPlaceByRearranging(A, B);
		System.out.println();
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));
	}

	/**
	 * merge sorted arrays with O(1) space.
	 * 
	 * Time Complexity  : O(m*n)
	 * Space Complexity : O(1)
	 * 
	 * @param a
	 * @param b
	 */
	private static void mergeInPlaceByRearranging(int[] a, int[] b) {
		// Iterate over second shorter array from rear
		for (int i = b.length - 1; i >= 0; i--) {
			// capture last element of first array
			int j, last = a[a.length - 1];
			// Iterate over first array from rear till
			// you find an element which is greater than
			// last element of second array
			for (j = a.length - 2; j > 0 && a[j] > b[i]; j--) {
				a[j+1] = a[j];
			}
			if (j != a.length - 2 || last > b[i]) {
				a[j+1] = b[i];
				b[i] = last;
			}
		}
	}

	/**
	 * merge using an extra array
	 * 
	 * Time complexity  : O(m+n)
	 * Space complexity : O(m+n)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[] mergeInNewArray(int[] a, int[] b) {
		int i=0, j=0, k=0;
		int[] c = new int[a.length + b.length];
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			} else if (a[i] > b [j]) {
				c[k++] = b[j++];
			} else {
				c[k++] = a[i++];
				c[k++] = b[j++];
			}
		}
		while (i < a.length) {
			c[k++] = a[i++];
		}
		while (j < b.length) {
			c[k++] = b[j++];
		}
		return c;
	}

}
