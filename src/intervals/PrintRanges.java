package intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jigar Gosalia
 *
 */
public class PrintRanges {

	public static void main(String[] args) {
		printRanges(new int[] { 0, 1, 3, 8 });
		System.out.println();
		printRanges(new int[] { 0, 8 });
		System.out.println();
		printRanges(new int[] { 1, 3, 4, 5, 7, 8, 10 });
		System.out.println();
		printRanges(new int[] { 1, 2, 3, 4, 5 });
		System.out.println();
		printRanges(new int[] { 1, 3, 5, 7, 9, 10 });
		System.out.println();
		printRanges(new int[] { 1, 2, 3, 4, 5, 9, 10, 11 });

	}

	public static void printRanges(int[] a) {
		List<String> ranges = new ArrayList<String>();
		int s = 0, i;
		for (i = 1; i < a.length; i++) {
			if (a[i] - a[i - 1] != 1) {
				// handle first single character
				if (i - s == 1) {
					ranges.add(a[s] + "");
				} else {
					// handle all use cases
					ranges.add(a[s] + "-" + a[i - 1]);
				}
				s = i;
			}
		}
		// handle last single character
		if (s == a.length - 1) {
			ranges.add(a[s] + "");
		}
		// handle range at end
		if (s >= 0 && i == a.length) {
			ranges.add(a[s] + "-" + a[a.length - 1]);
		}
		System.out.println(ranges);
	}
}
