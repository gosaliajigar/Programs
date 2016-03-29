package com.programs.sorting;

import java.util.Arrays;

/**
 * Merge sort is a sorting technique based on divide and conquer technique. With
 * worst-case time complexity being Ο(n log n), it is one of the most respected
 * algorithms.<br>
 * <br>
 * 
 * Merge sort first divides the array into equal halves and then combines them
 * in a sorted manner.<br>
 * <br>
 * 
 * Time Complexity : O(nlogn)
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MergeSort {

	/**
	 * 
	 */
	private static Integer[] array = { 9, 8, 7, 6, 3, 1, 2, 4, 5 };

	/**
	 * 
	 */
	private static Integer[] temp = new Integer[array.length];

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		System.out.println(Arrays.toString(array));
		mergeSort();
		System.out.println(Arrays.toString(array));
	}

	/**
	 * @param low
	 * @param high
	 */
	private static void sort(int low, int high) {
		int mid;
		if (low < high) {
			mid = (low + high) / 2;
			sort(low, mid);
			sort(mid + 1, high);
			merge(low, mid, high);
		}
		return;
	}

	/**
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void merge(int low, int mid, int high) {
		int l1, l2, i;

		// Compare numbers from both the halves and copy them sorted in temp
		for (l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
			if (array[l1] <= array[l2])
				temp[i] = array[l1++];
			else
				temp[i] = array[l2++];
		}

		// if second half is completed
		while (l1 <= mid)
			temp[i++] = array[l1++];

		// if first half is completed
		while (l2 <= high)
			temp[i++] = array[l2++];

		// copy sorted array back to original array
		for (i = low; i <= high; i++)
			array[i] = temp[i];
	}

	/**
	 * @param array
	 */
	private static void mergeSort() {
		sort(0, array.length - 1);
	}
}
