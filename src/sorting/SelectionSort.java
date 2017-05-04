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
		Integer[] intArr = { 9, 8, 7, 6, 3, 1, 2, 4, 5 };
		selectionSort(intArr);
	}

	/**
	 * @param inputArray
	 */
	public static void selectionSort(Integer[] inputArray) {

		int iterations = 0;
		int indexMin, i, j;

		// loop through all numbers
		for (i = 0; i < inputArray.length - 1; i++) {
			// set current element as minimum
			indexMin = i;

			// check the element to be minimum
			for (j = i + 1; j < inputArray.length; j++) {
				iterations++;
				if (inputArray[j] < inputArray[indexMin]) {
					indexMin = j;
				}
			}

			// swap the numbers
			if (indexMin != i) {
				int temp = inputArray[indexMin];
				inputArray[indexMin] = inputArray[i];
				inputArray[i] = temp;
			}
		}
		System.out.println("Iterations:<" + iterations + "> Size:<" + inputArray.length + ">");
		System.out.println("-" + Arrays.toString(inputArray));
	}
}
