package com.programs.sorting;

import java.util.Arrays;

/**
 * Insertion sort is an in-place sorting algorithm.<br>
 * <br>
 * 
 * Here, a sub-list is maintained which is always sorted. For example, the lower
 * part of an array is maintained to be sorted. A element which is to be
 * 'insert'ed in this sorted sub-list, has to find its appropriate place and
 * insert it there. Hence the name insertion sort.<br>
 * <br>
 * 
 * Time Complexity : O(n^2).
 * 
 * @author "Jigar Gosalia"
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Integer[] intArr = { 9, 8, 7, 6, 3, 1, 2, 4, 5 };
		insertionSort(intArr);
	}

	/**
	 * Insertion Sort
	 *
	 * @param inputArray
	 */
	public static void insertionSort(final Integer[] inputArray) {
		int valueToInsert;
		int holePosition;
		int position = 0;
		int iterations = 0;

		// loop through all numbers
		for (position = 1; position < inputArray.length; position++) {
			// select a value to be inserted.
			valueToInsert = inputArray[position];

			// select the hole position where number is to be inserted
			holePosition = position;

			// check if previous no. is larger than value to be inserted
			while (holePosition > 0 && inputArray[holePosition - 1] > valueToInsert) {
				iterations++;
				inputArray[holePosition] = inputArray[holePosition - 1];
				holePosition--;
			}

			if (holePosition != position) {
				// insert the number at hole position
				inputArray[holePosition] = valueToInsert;
			}
		}
		System.out.println("Iterations:<" + iterations + "> Size:<" + inputArray.length + ">");
		System.out.println("-" + Arrays.toString(inputArray));
	}
}
