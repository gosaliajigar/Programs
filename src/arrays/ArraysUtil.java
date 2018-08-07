package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * useful methods of Arrays
 * 
 * @author Jigar Gosalia
 *
 */
public class ArraysUtil {

	public static void main(String[] args) {
		int[] a = new int[] { 2, 8, 3, 1, 7, 0, 5, 4, 9, 10, 11, 6 };
		int[] b = a.clone();
		
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		// sort range (toIndex exclusive)
		Arrays.sort(a, 2, 7);
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		// sort
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println();

		// binarySearch range
		System.out.println(Arrays.binarySearch(a, 2, 7, 2));
		System.out.println();
		
		// binarySearch
		System.out.println(Arrays.binarySearch(a, 10));
		System.out.println();

		// copyOf Array
		System.out.println(Arrays.toString(Arrays.copyOf(a, 4)));
		System.out.println();

		// copyOfRange Array
		System.out.println(Arrays.toString(Arrays.copyOfRange(a, 3, 9)));
		System.out.println();
		
		// allows usage of Comparator when array is an array of Objects (not primitive)
		Arrays.sort(b);
		// equals compares value and order both
		System.out.println(Arrays.equals(a, b));
		System.out.println();

		// stream converts
		System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
		System.out.println();

		// fill
		Arrays.fill(a, -1);
		System.out.println(Arrays.toString(a));
		System.out.println();

		// asList converts integers into a List
		System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	}
}
