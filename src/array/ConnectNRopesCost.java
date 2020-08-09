package array;

import java.util.PriorityQueue;

/**
 * 
 * There are given n ropes of different lengths, we need to connect these ropes
 * into one rope. The cost to connect two ropes is equal to sum of their
 * lengths. We need to connect the ropes with minimum cost.
 * 
 * Source : https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 * 
 * @author Jigar Gosalia
 *
 */
public class ConnectNRopesCost {

	public static void main(String[] args) {
		System.out.println(minCost(new int[] {4, 3, 2, 6}));
	}
	
	public static int minCost(int[] a) {
		// Create a priority queue (default is min heap)
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		// Adding items to the queue
		for (int i : a) { queue.offer(i); }
		int sum = 0;
		// While size of priority queue is more than 1
		while (queue.size() > 1) {
			// Extract shortest two ropes from queue
			int first = queue.poll(), second = queue.poll();
			// Connect the ropes: update result
			// and insert the new rope to queue
			sum += first + second;
			queue.offer(first + second);
		}
		return sum;
	}
}
