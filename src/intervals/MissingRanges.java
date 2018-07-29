package intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a sorted integer array where the range of elements are [0, 99]
 * inclusive, return its missing ranges. For example, given [0, 1, 3, 50, 75],
 * return [2, 4->49, 51->74, 76->99]
 * 
 * @author Jigar Gosalia
 *
 */
public class MissingRanges {
	public static void main(String[] args) {
		System.out.println(missingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
		System.out.println(missingRanges(new int[] {10, 30, 50, 75}, 0, 99));
	}

	public static List<String> missingRanges(int[] a, int start, int end) {
		List<String> ranges = new ArrayList<String>();
		if (a == null || a.length == 0) return ranges;
		int prev = start - 1;
		for (int i = 0; i <= a.length; i++) {
			int curr = (i == a.length) ? end + 1 : a[i];
			if (curr - prev >= 2) {
				ranges.add(getRange(prev + 1, curr - 1));
			}
			prev = curr;
		}
		return ranges;
	}

	private static String getRange(int from, int to) {
		return (from == to) ? String.valueOf(from) : from + "->" + to;
	}
}
