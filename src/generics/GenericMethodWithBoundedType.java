package generics;

/**
 * Generic Method with Bounded Types
 *
 * @author "Jigar Gosalia"
 *
 */
public class GenericMethodWithBoundedType {

	public static void main(final String args[]) {
		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));

		System.out.printf("Max of %.1f, %.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

		System.out.printf("Max of %s, %s and %s is %s", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
	}

	/**
	 * Determines the largest of three Comparable objects
	 *
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		// assume x is initially the largest
		T max = x;
		if (y.compareTo(max) > 0) {
			// y is the largest so far
			max = y;
		}
		if (z.compareTo(max) > 0) {
			// z is the largest now
			max = z;
		}
		// returns the largest object
		return max;
	}
}
