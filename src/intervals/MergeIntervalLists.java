package intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import pojos.Interval;

/**
 * 
 * Merge two interval lists into single list.
 * 
 * A: [1,5], [10,14], [16,18]
 * B: [2,6], [8,10], [11,20]
 * output [1,6], [8,20]
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

	public static void main(String[] args) {
		System.out.println(merge(new Interval[] {new Interval(1, 5), new Interval(10, 14), new Interval(16, 18)}, 
								new Interval[] {new Interval(2, 6), new Interval(8, 10), new Interval(11, 20)}));
	}

	public static List<Interval> merge(Interval[] a, Interval[] b) {
		List<Interval> results = new ArrayList<Interval>();
		PriorityQueue<Interval> queue = new PriorityQueue<Interval>(sortByStartTimes);
		int i=0, j=0;
		while (i<a.length||j<b.length) {
			if (i<a.length) queue.offer(a[i++]);
			if (j<b.length) queue.offer(b[j++]);
		}
		Interval prev = queue.poll();
		while (!queue.isEmpty()) {
			Interval curr = queue.poll();
			if (prev.end < curr.start) {
				results.add(prev);
				prev = curr;
			} else if (prev.start > curr.end) {
				results.add(curr);
			} else {
				prev = new Interval(prev.start, Math.max(prev.end, curr.end));
			}
		}
		results.add(prev);
		return results;
	}
}
