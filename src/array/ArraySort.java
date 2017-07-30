package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * How to sort an array in Java
 *
 * @author "Jigar Gosalia"
 *
 */
public class ArraySort {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		int[] intArr = { 1, 4, 2, 6, 3 };
		String[] strArr = { "E", "A", "U", "O", "I" };

		// Arrays.sort(T[] t) uses Dual-Pivot Quick sort algorithm with
		// performance of O(n log(n)).
		// The sorting is done in natural ascending order.
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
	}
}
