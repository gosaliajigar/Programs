package sorting;

import java.util.Arrays;

/**
 * Merge sort is a sorting technique based on divide and conquer technique. With
 * worst-case time complexity being O(n log n), it is one of the most respected
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

	private static int[] array = { 9, 8, 7, 6, 3, 1, 2, 4, 5 };

	private static int[] temp = new int[array.length];

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		System.out.println(Arrays.toString(array));
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * @param array
	 * @param low
	 * @param high
	 */
	private static void sort(int[] array, int low, int high) {
		int mid;
		if (low < high) {
			mid = (low + high) / 2;
			sort(array, low, mid);
			sort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
		return;
	}

	/**
	 * @param array
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void merge(int[] array, int low, int mid, int high) {
		int left, right, i;

		// Compare numbers from both the halves and copy them sorted in temp
		for (i = low, left = low, right = mid + 1; left <= mid && right <= high; i++) {
	        if (array[left] <= array[right])
	        	temp[i] = array[left++];
	        else
	        	temp[i] = array[right++];
		}

		// if right half is completed
		while (left <= mid)
			temp[i++] = array[left++];

		// if left half is completed
		while (right <= high)
		    temp[i++] = array[right++];

		// copy sorted array back to original array
		for (i = low; i <= high; i++)
		        array[i] = temp[i];
	}

	/**
	 * @param array
	 */
	private static void mergeSort(int[] array) {
		sort(array, 0, array.length - 1);
	}
}
