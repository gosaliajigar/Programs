package datastructure.queue;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Reverse Queue using Recursion
 * 
 * @author "Jigar Gosalia"
 *
 */
public class ReverseQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1); queue.add(2); queue.add(3); queue.add(4);
		queue.add(5); queue.add(6); queue.add(7); queue.add(8);
		queue.add(9);
		System.out.println(queue);
		queue = reverseQueue(queue);
		System.out.println(queue);
	}

	public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
		if (queue == null ||  queue.isEmpty()) return queue;
		int data = queue.remove();
		queue = reverseQueue(queue);
		queue.add(data);
		return queue;
	}
}
