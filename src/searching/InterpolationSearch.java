package searching;

/**
 * Interpolation search is an improved variant of binary search. This search
 * algorithm works on the probing position of required value. For this algorithm
 * to work properly the data collection should be in <b>sorted form and equally
 * distributed</b>.<br>
 * <br>
 * 
 * Even when the data is sorted, binary search does not take advantage of that
 * to probe the position of desired data.<br>
 * <br>
 * 
 * Interpolation Search searches a particular item by computing the probe
 * position. Initially probe position is the position of the middle most item of
 * the collection. <br>
 * <br>
 * 
 * Time Complexity : O(log(log n))
 * 
 * @author "Jigar Gosalia"
 *
 */
public class InterpolationSearch {

	public static int MAX_SIZE = 400;
	public static int[] array = new int[MAX_SIZE];

	public static void main(String[] args) {
		populateData(array);
		interpolationSearch(array, 232);
	}

	private static void interpolationSearch(int[] a, int x) {
		int index = -1;
		int low = 0;
		int high = a.length - 1;
		int iterations = 0;
		int mid;

		while (low <= high) {
			iterations++;
			mid = low + (((high - low) / (a[high] - a[low]))
					* (x - a[low]));
			// data is greater than value at middle, hence it is more towards
			// upperBound, so move lowerBound
			if (a[mid] < x) {
				low = mid + 1;
				// data is smaller than value at middle, hence it is more
				// towards lowerBound, so move upperBound
			} else if (a[mid] > x) {
				high = mid - 1;
				// found data at middle
			} else {
				index = mid;
				break;
			}
		}
		System.out.println("No of Iterations                  : " + iterations);
		System.out.println("Theoretical Iterations(log(log n)): "
				+ (Math.log((Math.log(a.length) / Math.log(2))) / Math.log(2)));
		System.out.println();
		if (index != -1) {
			System.out.println("Found " + x + " at location   : " + index);
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
