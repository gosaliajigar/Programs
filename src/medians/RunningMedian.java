package medians;
import java.util.Comparator;
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

	// max heap for lower values
	private	static Queue<Integer> lowerValues = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -1 * o1.compareTo(o2);
			}
		});

	// min heap for higher values
	private	static Queue<Integer> higherValues = new PriorityQueue<Integer>();

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int value = scanner.nextInt();
			double median = getRunningMedian(value);
			System.out.println("MaxHeap : " + lowerValues);
			System.out.println("MinHeap : " + higherValues);
			System.out.println("Median  : " + median);
			System.out.println();
		}
	}

	public static double getRunningMedian(int value) {
		// add new value to heaps
		if (lowerValues.size() == 0 || value < lowerValues.peek()) {
			lowerValues.add(value);
		} else {
			higherValues.add(value);
		}

		// balance heaps
		while (Math.abs(lowerValues.size() - higherValues.size()) > 1) {
			if (lowerValues.size() > higherValues.size()) {
				higherValues.add(lowerValues.poll());
			} else {
				lowerValues.add(higherValues.poll());
			}
		}

		// get median either from max size heap or average of two equal heaps 
		if (lowerValues.size() > higherValues.size()) {
			return lowerValues.peek();
		} else if (lowerValues.size() < higherValues.size()) {
			return higherValues.peek();
		} else {
			// NOTE: double casting here else your value will be truncated
			return (((double)lowerValues.peek() + higherValues.peek()) / 2);
		}
	}
}