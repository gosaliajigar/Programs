package sorting;

import java.util.Arrays;

/**
 * Selection sort is a in-place comparison based algorithm.<br>
 * Can be stable or unstable both.
 * Source : https://stackoverflow.com/questions/20761396/why-selection-sort-can-be-stable-or-unstable
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

	public static void main(String[] args) {
		Integer[] intArr = { 9, 8, 7, 6, 3, 1, 2, 4, 5, 2, 1, 2, 2, 2 };
		selectionSort(intArr);
	}

	public static void selectionSort(Integer[] a) {
		int iterations = 0;
		// loop through all numbers
		for (int i = 0; i < a.length-1; i++) {
			// set current element as minimum
			int minIndex = i;
			// check the element to be minimum
			for (int j = i + 1; j < a.length; j++) {
				iterations++;
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			// swap the numbers
			if (minIndex != i) {
				int temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
			}
		}
		System.out.println("Iterations:<" + iterations + "> Size:<" + a.length + ">");
		System.out.println("-" + Arrays.toString(a));
	}
}
