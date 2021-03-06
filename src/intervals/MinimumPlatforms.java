package intervals;

import java.util.PriorityQueue;

/**
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that
 * no train waits.
 * 
 * @author Jigar Gosalia
 *
 */
public class MinimumPlatforms {

	public static void main(String[] args) {
		int arrivals[] = { 900, 940, 950, 1100, 1500, 1800 };
		int departures[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println(minPlatforms(arrivals, departures));
		System.out.println(minPlatformsUsingPriorityQueue(arrivals, departures));
		System.out.println();
		arrivals = new int[] { 200, 210, 300, 320, 350, 500 };
		departures = new int[] { 230, 340, 320, 430, 400, 520 };
		System.out.println(minPlatforms(arrivals, departures));
		System.out.println(minPlatformsUsingPriorityQueue(arrivals, departures));
	}

	public static int minPlatforms(int[] arrivals, int[] departures) {
		// platforms indicates platforms # needed at a time
		int i = 1, j = 0, max = 1, platforms = 1;

		// Similar to merge in merge sort to process
		// all events in sorted order
		while (i < arrivals.length && j < departures.length) {
			// If next event in sorted order is arrival,
			// increment count of platforms needed
			if (arrivals[i] < departures[j]) {
				platforms++;
				// increment arrival as arrival at [i] needs a separate platform
				i++;
				max = Math.max(max, platforms);
				// else decrement count of platforms needed
			} else {
				platforms--;
				j++;
			}
		}
		return max;
	}

	private static int minPlatformsUsingPriorityQueue(int[] arrivals, int[] departures) {
		int platforms = 1;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.offer(departures[0]);
		for (int i=1; i<arrivals.length; i++) {
			// arrival time is less means it needs a new platform
			if (queue.peek()>arrivals[i]) {
				platforms++;
			} else {
				queue.poll();
			}
			queue.offer(departures[i]);
		}
		return platforms;
	}
}
