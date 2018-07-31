package array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * Given an array of N integers with duplicates allowed. All elements are ranked
 * from 1 to N if they are distinct. If there are say x repeated elements of a
 * particular value then each element should be assigned a rank equal to the
 * arithmetic mean of x consecutive ranks.
 * 
 * 
 * Source : https://www.geeksforgeeks.org/rank-elements-array/
 * 
 * @author Jigar Gosalia
 *
 */
public class RankElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getRanks(new int[] { 20, 30, 10 })));
		System.out.println();
		System.out.println(Arrays.toString(getRanks(new int[] { 10, 12, 15, 12, 10, 25, 12 })));
		System.out.println();
		System.out.println(Arrays.toString(getRanks(new int[] { 1, 2, 5, 2, 1, 60, 3 })));
		System.out.println();
	}

	public static double[] getRanks(int[] arr) {
		// clone given array
		int[] a = arr.clone();
		// rank array
		double[] b = new double[a.length];
		Map<Integer, Double> ranks = new LinkedHashMap<Integer, Double>();
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			// do not use this if intention is to override 
			// values as putIfAbsent only works if key not present
			ranks.putIfAbsent(a[i], getRank(a, a[i]));
		}
		for (int i=0; i<arr.length; i++) {
			b[i] = ranks.get(arr[i]);
		}
		return b;
	}

	public static double getRank(int[] a, int element) {
		int first = firstOccurrence(a, 0, a.length - 1, element) + 1;
		int last = lastOccurrence(a, 0, a.length - 1, element) + 1;
		int count = last - first + 1;
		// sum of positions of a number i.e. 3+4+5 for an element at location 3,4,5
		// while (first <= last) { sum += first; first++; } 
		double sum = ((last * (last + 1)) / 2.0) - (((first - 1) * first) / 2.0);
		return sum / count;
	}

	private static int firstOccurrence(int[] a, int left, int right, int x) {
		if (left <= right) {
			int mid = ((left + right) / 2);
			if (a[mid] == x && (mid == 0 || a[mid - 1] < a[mid])) {
				return mid;
			} else if (a[mid] < x) {
				return firstOccurrence(a, (mid + 1), right, x);
			} else {
				return firstOccurrence(a, left, (mid - 1), x);
			}
		}
		return -1;
	}

	private static int lastOccurrence(int[] a, int left, int right, int x) {
		if (left <= right) {
			int mid = ((left + right) / 2);
			if (a[mid] == x && (mid == a.length - 1 || a[mid + 1] > a[mid])) {
				return mid;
			} else if (a[mid] > x) {
				return lastOccurrence(a, left, mid - 1, x);
			} else {
				return lastOccurrence(a, mid + 1, right, x);
			}
		}
		return -1;
	}

}
