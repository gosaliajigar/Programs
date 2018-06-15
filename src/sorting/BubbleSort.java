package sorting;

import java.util.Arrays;

/**
 * Bubble sort is an in-place and stable sorting algorithm. <br>
 * <br>
 * 
 * This sorting algorithm is comparison based algorithm in which each pair of
 * adjacent elements is compared and elements are swapped if they are not in
 * order. <br>
 * <br>
 * 
 * Time Complexity : O(n^2).
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Integer[] intArr = { 9, 8, 7, 6, 3, 1, 2, 4, 5 };
		String[] strArr = { "E", "A", "U", "O", "I" };

		bubbleSort(intArr);
		bubbleSort(strArr);
	}

	/**
	 * Bubble Sort
	 *
	 * @param input
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] input) {
		int iterations = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length - 1; j++) {
				iterations++;
				// Swap only if element is greater then next element.
				// Bubble up higher number to end of array.
				if (input[j].compareTo(input[j + 1]) > 0) {
					T temp = input[j + 1];
					input[j + 1] = input[j];
					input[j] = temp;
				}
			}
		}
		System.out.println("Iterations:<" + iterations + "> Size:<" + input.length + ">");
		System.out.println("-" + Arrays.toString(input));
	}
}
