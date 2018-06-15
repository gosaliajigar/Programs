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
 * not in-place but stable<br>
 * <br>
 *  
 * Time Complexity : O(nlogn)
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MergeSort {

	private static int[] array = { 9, 8, 7, 6, 3, 1, 2, 4, 5, 2, 2, 1, 1 };

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
	 * @param a
	 * @param low
	 * @param high
	 */
	private static void sort(int[] a, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(a, low, mid);
			sort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
		return;
	}

	/**
	 * @param a
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void merge(int[] a, int low, int mid, int high) {
		int left=low, right=mid+1, i=low;

		// Compare numbers from both the halves and copy them sorted in temp
		while (left<= mid && right <= high) {
	        if (a[left] <= a[right])
	        	temp[i++] = a[left++];
	        else
	        	temp[i++] = a[right++];
		}

		// if right half is completed
		while (left <= mid)
			temp[i++] = a[left++];

		// if left half is completed
		while (right <= high)
		    temp[i++] = a[right++];

		// copy sorted array back to original array
		for (i = low; i <= high; i++)
		        a[i] = temp[i];
	}

	/**
	 * @param array
	 */
	private static void mergeSort(int[] array) {
		sort(array, 0, array.length - 1);
	}
}
