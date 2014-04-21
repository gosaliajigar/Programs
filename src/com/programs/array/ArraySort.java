package com.programs.array;

import java.util.Arrays;

/**
 *
 * This class shows how to sort an array in Java
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
		int[] bubbleArr = { 1, 4, 2, 6, 3 };

		// Arrays.sort(T[] t) uses Dual-Pivot Quicksort algorithm with
		// performance of O(n log(n)).
		// The sorting is done in natural ascending order.
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		bubbleSort(bubbleArr);
		System.out.println("Bubble Sort : " + Arrays.toString(bubbleArr));
	}

	/**
	 * Bubble Sort
	 *
	 * @param inputArray
	 */
	public static void bubbleSort(final int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i; j < inputArray.length - i - 1; j++) {
				if (inputArray[j] > inputArray[j + 1]) {
					int temp = inputArray[j + 1];
					inputArray[j + 1] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
	}
}
