package com.programs.sorting;

import java.util.Arrays;

/**
 * Quick sort is a highly efficient sorting algorithm and is based on
 * partitioning of array of data into smaller arrays. A large array is
 * partitioned into two arrays one of which holds values smaller than specified
 * value say pivot based on which the partition is made and another array holds
 * values greater than pivot value.<br>
 * <br>
 * 
 * The quick sort partitions an array and then calls itself recursively twice to
 * sort the resulting two sub-array. This algorithm is quite efficient for large
 * sized data sets as its average and worst case complexity are of O(nlogn)
 * where n are no. of items.<br>
 * <br>
 * 
 * Time Complexity : O(nlogn)
 * 
 * @author "Jigar Gosalia"
 *
 */
public class QuickSort {

	/**
	 * 
	 */
	private static Integer[] intArray = { 9, 8, 7, 6, 3, 1, 2, 4, 5 };

	/**
	 * @param num1
	 * @param num2
	 */
	public static void swap(int num1, int num2) {
		int temp = intArray[num1];
		intArray[num1] = intArray[num2];
		intArray[num2] = temp;
	}

	/**
	 * @param left
	 * @param right
	 * @param pivot
	 * @return
	 */
	public static int partition(int left, int right, int pivot) {
		int leftPointer = left - 1;
		int rightPointer = right;

		while (true) {

			while (intArray[++leftPointer] < pivot) {
				// do nothing
			}

			while (rightPointer > 0 && intArray[--rightPointer] > pivot) {
				// do nothing
			}

			if (leftPointer >= rightPointer) {
				break;
			} else {
				swap(leftPointer, rightPointer);
			}
		}
		swap(leftPointer, right);
		return leftPointer;
	}

	/**
	 * @param left
	 * @param right
	 */
	public static void quickSort(int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			int pivot = intArray[right];
			int partitionPoint = partition(left, right, pivot);
			quickSort(left, partitionPoint - 1);
			quickSort(partitionPoint + 1, right);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("Input Array: " + Arrays.toString(intArray));
		quickSort(0, intArray.length - 1);
		System.out.printf("Output Array: " + Arrays.toString(intArray));
	}
}
