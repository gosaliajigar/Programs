package com.programs.sorting;

import java.util.Arrays;

/**
 * Bubble sort is an in-place sorting algorithm. <br>
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
	 * @param inputArray
	 */
	public static <T extends Comparable<T>> void bubbleSort(final T[] inputArray) {
		int iterations = 0;
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray.length - 1; j++) {
				iterations++;
				// Swap only if element is greater then next element.
				// Bubble up higher number to end of array.
				if (inputArray[j].compareTo(inputArray[j + 1]) > 0) {
					T temp = inputArray[j + 1];
					inputArray[j + 1] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		System.out.println("Iterations:<" + iterations + "> Size:<" + inputArray.length + ">");
		System.out.println("-" + Arrays.toString(inputArray));
	}
}
