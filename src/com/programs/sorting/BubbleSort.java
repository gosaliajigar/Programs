package com.programs.sorting;

import java.util.Arrays;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Integer[] intArr = { 1, 4, 2, 6, 3 };
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
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i; j < inputArray.length - i - 1; j++) {
				if (inputArray[j].compareTo(inputArray[j + 1]) > 0) {
					T temp = inputArray[j + 1];
					inputArray[j + 1] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(inputArray));
	}
}
