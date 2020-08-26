package inversion;

import java.util.Arrays;

/**
 * Count no. of inversions in nlogn time.
 * 
 * - Inversion Count for an array indicates – how far (or close) the array is from being sorted. 
 * - If array is already sorted then inversion count is 0. 
 * - If array is sorted in reverse order that inversion count is the maximum.
 * - Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j 
 * 
 * Source : https://www.geeksforgeeks.org/counting-inversions/
 * 
 * @author Jigar Gosalia
 *
 */
public class InversionCount {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 20, 6, 4, 5 };
		System.out.println(getInversionCount(a));
		System.out.println(inversions(a));
		System.out.println(Arrays.toString(a));
	}

	// n^2 and 1
	public static int getInversionCount(int[] a) {
		int invCount = 0;
		for (int i = 0; i < a.length - 1; i++)
			for (int j = i + 1; j < a.length; j++)
				if (a[i] > a[j])
					invCount++;
		return invCount;
	}

	// nlogn and n
	public static int inversions(int[] a) {
		return mergeSort(a, 0, a.length - 1);
	}

	public static int mergeSort(int[] a, int low, int high) {
		int inversions = 0;
		if (low < high) {
			int mid = low + (high - low) / 2;
			inversions += mergeSort(a, low, mid);
			inversions += mergeSort(a, mid + 1, high);
			inversions += merge(a, low, mid, high);
		}
		return inversions;
	}

	public static int merge(int[] a, int low, int mid, int high) {
		int i = low, j = mid + 1, k = low, inversions = 0;
		int[] temp = new int[a.length];
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else if (a[i] > a[j]) {
				// all remaining elements in left-sub array (a[i+1], a[i+2] -> a[mid])
				// will be greater than a[j]
				inversions += (mid - i + 1);
				temp[k++] = a[j++];
			} else {
				temp[k++] = a[i++];
				temp[k++] = a[j++];
			}
		}
		while (i <= mid)
			temp[k++] = a[i++];
		while (j <= high)
			temp[k++] = a[j++];
		for (int t = low; t <= high; t++) {
			a[t] = temp[t];
		}
		return inversions;
	}
}
