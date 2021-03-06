package searching;

/**
 * Linear search is a very simple search algorithm. In this type of search, a
 * sequential search is made over all items one by one. Every items is checked
 * and if a match founds then that particular item is returned otherwise search
 * continues till the end of the data collection.<br>
 * <br>
 * Time Complexity : O(n)
 * 
 * @author "Jigar Gosalia"
 *
 */
public class LinearSearch {

	public static int MAX_SIZE = 400;
	public static int[] array = new int[MAX_SIZE];

	public static void main(String[] args) {
		populateData(array);
		linearSearch(array, 322);
	}

	private static void linearSearch(int[] a, int x) {
		int index = -1;
		int iterations = 0;

		for (int i = 0; i < a.length; i++) {
			iterations++;
			if (a[i] == x) {
				index = i;
				break;
			}
		}
		System.out.println("No of Iterations: " + iterations);
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
