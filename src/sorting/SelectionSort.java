package sorting;

import java.util.Arrays;

/**
 * Selection sort is a in-place comparison based algorithm.<br>
 * <br>
 * 
 * Selection sort is a simple sorting algorithm in which the list is divided
 * into two parts, sorted part at left end and unsorted part at right end.
 * Initially sorted part is empty and unsorted part is entire list.<br>
 * <br>
 * 
 * Smallest element is selected from the unsorted array and swapped with the
 * leftmost element and that element becomes part of sorted array. This process
 * continues moving unsorted array boundary by one element to the right.<br>
 * <br>
 * 
 * Time Complexity : O(n^2)
 * 
 * @author "Jigar Gosalia"
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] intArr = { 9, 8, 7, 6, 3, 1, 2, 4, 5, 2, 1, 2, 2, 2 };
		selectionSort(intArr);
	}

	/**
	 * @param input
	 */
	public static void selectionSort(Integer[] input) {

		int iterations = 0;

		// loop through all numbers
		for (int i = 0; i < input.length - 1; i++) {
			// set current element as minimum
			int minIndex = i;
			// check the element to be minimum
			for (int j = i + 1; j < input.length; j++) {
				iterations++;
				if (input[j] < input[minIndex]) {
					minIndex = j;
				}
			}
			// swap the numbers
			if (minIndex != i) {
				int temp = input[minIndex];
				input[minIndex] = input[i];
				input[i] = temp;
			}
		}
		System.out.println("Iterations:<" + iterations + "> Size:<" + input.length + ">");
		System.out.println("-" + Arrays.toString(input));
	}
}
