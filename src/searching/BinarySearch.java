package searching;

/**
 * Binary search is a fast search algorithm with run-time complexity of O(log
 * n). This search algorithm works on the principle of divide and conquer. For
 * this algorithm to work properly the data collection should be in <b>sorted form</b>.<br>
 * <br>
 * Binary search searches a particular item by comparing the middle most item of
 * the collection. If match occurs then index of item is returned. If middle
 * item is greater than item then item is searched in sub-array to the right of
 * the middle item other wise item is search in sub-array to the left of the
 * middle item. This process continues on sub-array as well until the size of
 * sub array reduces to zero.<br>
 * <br>
 * Time Complexity : O(logn)
 * 
 * @author "Jigar Gosalia"
 *
 */
public class BinarySearch {

	public static int MAX_SIZE = 400;
	public static int[] array = new int[MAX_SIZE];

	public static void main(String[] args) {
		populateData(array);
		binarySearch(array, 322);
	}

	private static void binarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid = -1;
		int index = -1;
		int iterations = 0;

		while (low <= high) {
			iterations++;
			mid = low + ((high - low) / 2);
			// data is greater than value at middle, hence it is more towards
			// upperBound, so move lowerBound
			if (a[mid] < x) {
				low = mid + 1;
				// data is smaller than value at middle, hence it is more
				// towards lowerBound, so move upperBound
			} else if (a[mid] > x) {
				high = mid - 1;
			} else {
				// found data at middle
				index = mid;
				break;
			}
		}
		System.out.println("No of Iterations             : " + iterations);
		System.out.println("Theoretical Iterations(log n): " + (Math.log(a.length) / Math.log(2)));
		if (index != -1) {
			System.out.println("Found " + x + " at location: " + index);
		} else {
			System.out.println("Couldn't find " + x);
		}
	}

	private static void populateData(int[] array) {
		for (int index = 0; index < array.length; index++) {
			array[index] = 2 * index;
		}
	}
}
