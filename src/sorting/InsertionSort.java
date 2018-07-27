package sorting;

import java.util.Arrays;

/**
 * Insertion sort is an in-place and stable sorting algorithm.<br>
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

	public static void main(final String[] args) {
		Integer[] intArr = { 9, 8, 7, 6, 3, 1, 2, 4, 5 };
		insertionSort(intArr);
	}

	/**
	 * Insertion Sort
	 *
	 * @param a
	 */
	public static void insertionSort(final Integer[] a) {
		int valueToInsert, holePosition, position, iterations = 0;

		// loop through all numbers
		for (position = 1; position < a.length; position++) {
			// select a value to be inserted.
			valueToInsert = a[position];

			// select the hole position where number is to be inserted
			holePosition = position - 1;

			// check if previous no. is larger than value to be inserted
			while (holePosition >= 0 && a[holePosition] > valueToInsert) {
				iterations++;
				a[holePosition + 1] = a[holePosition];
				holePosition--;
			}

			// insert the number at hole position
			a[holePosition + 1] = valueToInsert;
		}
		System.out.println("Iterations:<" + iterations + "> Size:<" + a.length + ">");
		System.out.println("-" + Arrays.toString(a));
	}
}
