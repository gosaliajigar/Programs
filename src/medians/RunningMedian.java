package medians;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Find running median using heaps.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class RunningMedian {

	// min heap
	private	static Queue<Integer> minHeap = new PriorityQueue<Integer>();

	// max heap
	private	static Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int value = scanner.nextInt();
			System.out.println("Median  : " + getMedian(value));
			System.out.println("MaxHeap : " + minHeap);
			System.out.println("MinHeap : " + maxHeap);
			System.out.println();
		}
	}

	private static double getMedian(int value) {
		maxHeap.offer(value);
		minHeap.offer(maxHeap.poll());
		if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
		return (maxHeap.size() == minHeap.size()) 
				? (maxHeap.peek()+minHeap.peek())/2.0 
						: maxHeap.peek();
	}
}