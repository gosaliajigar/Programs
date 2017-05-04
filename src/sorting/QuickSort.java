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
	private static int[] array = { 9, 8, 7, 6, 3, 1, 2, 4, 5 };

	/**
	 * @param num1
	 * @param num2
	 */
	public static void swap(int[] array, int num1, int num2) {
		int temp = array[num1];
		array[num1] = array[num2];
		array[num2] = temp;
	}

	/**
	 * @param p
	 * @param q
	 * @param pivot
	 * @return
	 */
	public static int partition(int[] array, int p, int q) {
		int x = array[p];
		int i = p;
		for (int j = p+1; j < q; j++) {
			if (array[j] <= x) {
				i = i + 1;
				swap(array, i, j);
			}
		}
		swap(array, p, i);
		System.out.println(" - " + Arrays.toString(array));
		return x;
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
		System.out.printf("Input Array  : " + Arrays.toString(array));
		System.out.println();
		quickSort(array, 0, array.length);
		System.out.println();
		System.out.printf("Output Array : " + Arrays.toString(array));
	}
}
