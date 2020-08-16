package sorting;

import java.util.Arrays;

/**
 * Bubble sort is an in-place and stable sorting algorithm.<br>
 * <br>
 * 
 * Bubble Sort can be optimized by adding a swapping flag which is set when
 * swapping is done in inner loop and it can be checked after every inner loop
 * execution so that if no elements are swapped then it means array is sorted.<br>
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
public class OptimizedBubbleSort {

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
			boolean swapped = false;
			for (int j = 0; j < input.length - 1; j++) {
				iterations++;
				// Swap only if element is greater then next element.
				// Bubble up higher number to end of array.
				if (input[j].compareTo(input[j + 1]) > 0) {
					swap(input, j, j + 1);
					swapped = true;
				}
			}
			// Check swapped flag after each inner iteration, if none of the
			// element is swapped then this means that the array is sorted.
			if (!swapped) break;
		}
		System.out.println("Iterations:<" + iterations + "> Size:<" + input.length + ">");
		System.out.println("-" + Arrays.toString(input));
	}

	public static <T> void swap(T[] input, int src, int dest) {
		T temp = input[src];
		input[src] = input[dest];
		input[dest] = temp;
	}
}
