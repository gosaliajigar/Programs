package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sort Queue without extra space O(n^2)
 *
 * Source : https://www.geeksforgeeks.org/sorting-queue-without-extra-space/
 * 
 * @author Jigar Gosalia
 */
public class SortQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(5); queue.offer(2); queue.offer(1); queue.offer(4); queue.offer(3);
		System.out.println(queue);
		sort(queue);
		System.out.println(queue);
	}

	public static void sort(Queue<Integer> queue) {
		// 1 to queue.size() ==> n iterations
		for (int i=1; i<=queue.size(); i++) {
			int minIndex = findMinIndex(queue, queue.size() - i);
			insertMinToRear(queue, minIndex);
		}
	}

	// we add the condition i <= index because we don't want to traverse
	// on the sorted part of the queue, which is the right most part.
	public static int findMinIndex(Queue<Integer> queue, int index) {
		int minIndex = -1, minValue = Integer.MAX_VALUE, size = queue.size();
		for (int i = 0; i < size; i++) {
			int current = queue.poll();
			if (current <= minValue && i <= index) {
				minIndex = i;
				minValue = current;
			}
			queue.offer(current);
		}
		return minIndex;
	}

	// find minIndex, skip pushing it in sequence and instead push it to rear
	public static void insertMinToRear(Queue<Integer> queue, int minIndex) {
		int minValue = 0, size = queue.size();
		for (int i = 0; i < size; i++) {
			int current = queue.poll();
			if (i != minIndex) queue.offer(current);
			else minValue = current;
		}
		queue.offer(minValue);
	}
}
