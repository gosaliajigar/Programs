package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import pojos.Interval;

/**
 * 
 * Source :
 * https://leetcode.com/discuss/interview-question/124616/Merge-two-interval-lists/
 * 
 * @author Jigar Gosalia
 *
 */
public class MergeIntervalLists {

	private static Comparator<Interval> sortByStartTimes = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	};

	public static List<Interval> merge(Interval[] a, Interval[] b) {
		List<Interval> results = new ArrayList<Interval>();
		Arrays.sort(a, sortByStartTimes);
		Arrays.sort(b, sortByStartTimes);
		Interval merged = null;
		int i=0, j=0;
		if (a[0].start < b[0].start) {
			merged = a[0]; i++;
		} else {
			merged = b[0]; j++;
		}
		while (i<a.length&&j<b.length) {
			if (merged.start < a[i].start && merged.end < a[i].end) {
				// merge wins
			} else if (merged.start > a[i].start && merged.end > a[i].end) {
				// a[i] wins
				
			} else {
				// merge both
				merged = new Interval(merged.start, Math.max(merged.end, a[i].end));
				i++;
			}
			if (merged.start < b[j].start && merged.end < b[j].end) {
				// merge wins
			} else if (merged.start > b[j].start && merged.end > b[j].end) {
				// b[j] wins
			} else {
				// merge both
				merged = new Interval(merged.start, Math.max(merged.end, b[j].end));
				j++;
			}
			
		}
		return results;
	}
}

class IntervalContainer {
	public Interval[] ic;
	public int index;
	public IntervalContainer(Interval[] ic, int index) { this.ic = ic; this.index = index; }
}