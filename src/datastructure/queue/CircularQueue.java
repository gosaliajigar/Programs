package datastructure.queue;

/**
 * 
 * @author Jigar Gosalia
 *
 */
public class CircularQueue<T> {

	private final int DEFAULT_CAPACITY = 2;
	private int front, rear, count;
	private T[] queue;
	
	public CircularQueue() {
		queue = (T[]) new Object[DEFAULT_CAPACITY];
	}

	public void enqueue(T element) {
		if (size() == queue.length) expandCapacity();
		queue[rear] = element;
		rear = (rear+1) % queue.length;
		count++;
	}
	
	private void expandCapacity() {
		T[] larger = (T[]) new Object[queue.length * 2];
		for (int scan=0; scan<count; scan++) {
			larger[scan] = queue[front];
			front = (front+1) % queue.length;
		}
		front = 0;
		rear = count;
		queue = larger;
	}

	public T dequeue() {
		T result = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		count--;
		return result;
	}
	
	public int size() { return count; }

	public boolean isEmpty() { return count == 0; }
	
	public static void main(String[] args) {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		for (int i=0; i< 20; i++) queue.enqueue(i);
		while (!queue.isEmpty()) { System.out.print(queue.dequeue() + " ");}
	}
}
