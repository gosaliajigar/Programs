package intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jigar Gosalia
 *
 */
public class SummaryRanges {

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
		List<String> result = new ArrayList<String>();
		int prev = a[0], first = prev;
		for (int i=1; i<a.length; i++) {
			if (a[i]==prev+1) {
				// check if last element
				if (i==a.length-1) {
					result.add(first + "-" + a[i]);
				}
			} else {
				if (first == prev) {
					result.add(first + "");
				} else {
					result.add(first + "-" + prev);
				}
				// check if last element
				if (i==a.length-1) {
					result.add("" + a[i]);
				}
				first = a[i];
			}
			prev = a[i];
		}
		System.out.println(result);
	}
}
