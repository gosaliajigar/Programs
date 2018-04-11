package sorting;

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

	/*	 */
	private static int[] array = { 9, 8, 7, 6, 3, 1, 2, 4, 5, 2, 2, 1, 1 };

	/**
	 * @param one
	 * @param two
	 */
	public static void swap(int[] array, int one, int two) {
		int temp = array[one];
		array[one] = array[two];
		array[two] = temp;
	}

	/**
	 * @param p
	 * @param r
	 * @param pivot
	 * @return
	 */
	public static int partition(int[] a, int p, int r) {
		// pivot = rear element
		int pivot = a[r];
		int i = p-1;
		for (int j = p; j < r; j++) {
			if (a[j] <= pivot) {
				i = i + 1;
				swap(a, i, j);
			}
		}
		swap(a, r, i+1);
		System.out.println(" - " + Arrays.toString(a));
		return (i+1);
	}

	/**
	 * @param p
	 * @param r
	 */
	public static void quickSort(int[] array, int p, int r) {
		if (p < r) {
			int q = partition(array, p, r);
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Input Array  : " + Arrays.toString(array));
		System.out.println();
		System.out.println(" - " + Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println();
		System.out.printf("Output Array : " + Arrays.toString(array));
	}
}




