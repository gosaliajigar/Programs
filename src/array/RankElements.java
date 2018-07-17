package array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
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
		int prev = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != prev) {
				ranks.put(a[i], getRank(a, a[i]));
			}
			prev = a[i];
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
		double sum = (last * (last + 1) / 2.0) - ((first - 1) / 2.0 * first);
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
