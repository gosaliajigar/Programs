package array;

import java.util.Arrays;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MergeSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1, 5, 9, 10, 15, 20};
		int[] B = {2, 3, 8, 13};
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));
		merge(A, B);
		System.out.println();
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));
	}

	/**
	 * merge sorted arrays with O(1) space.
	 * 
	 * Time Complexity : O(m*n)
	 * 
	 * @param a
	 * @param b
	 */
	private static void merge(int[] a, int[] b) {
		// Iterate over second array from rear
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

}
