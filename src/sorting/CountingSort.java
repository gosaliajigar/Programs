package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Counting sort is not in-place but a stable sorting algorithm. <br>
 * <br>
 * 
 * This sorting algorithm is non-comparison based algorithm in which numbers are
 * sorted by ordering them depending on number of numbers ahead of that number.<br>
 * <br>
 * 
 * Time Complexity : O(n+k) and if k = O(n) then its O(n).
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class CountingSort {

	private static final int SIZE = 20;

	// range of values in input array
	private static final int RANGE = 10;

	public static int[] countingSort(int[] A) {
		int[] C = new int[RANGE];
		int[] B = new int[A.length];

		// reset counting array
		for (int index = 0; index < C.length; index++) C[index] = 0;

		System.out.println("STEP1 C: " + Arrays.toString(C));
		System.out.println();

		// count occurrences
		for (int index = 0; index < A.length; index++) C[A[index]] = C[A[index]] + 1;

		System.out.println("STEP2 C: " + Arrays.toString(C));
		System.out.println();

		// get count of number itself and numbers less than itself
		for (int index = 1; index < C.length; index++) C[index] = C[index] + C[index - 1];

		System.out.println("STEP3 C: " + Arrays.toString(C));
		System.out.println();

		// start from rear end of array for stable sort
		for (int index = B.length - 1; index >=0; index--) {
			// NOTE: C would have count starting from 1 
			// so subtracting 1 is must
			B[C[A[index]] - 1] = A[index];
			C[A[index]] = C[A[index]] - 1;
		}
		System.out.println("STEP4 C: " + Arrays.toString(C));
		System.out.println();
		return B;
	}

	private static int[] populate(int size, int range) {
		int[] A = new int[size];
		Random random = new Random();
		for (int index = 0; index < size; index++) {
			A[index] = random.nextInt(range);
		}
		return A;
	}

	public static void main(String[] args) {
		int[] A = populate(SIZE, RANGE);
		System.out.println("INPUT  : " + Arrays.toString(A));
		System.out.println();
		int[] B = countingSort(A);
		System.out.println("OUTPUT : " + Arrays.toString(B));
	}
}
