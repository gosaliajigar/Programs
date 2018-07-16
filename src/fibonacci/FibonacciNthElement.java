package fibonacci;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Find nth element in Fibonacci series using recursion
 *
 * @author "Jigar Gosalia"
 *
 */
public class FibonacciNthElement {

	public static void main(final String[] args) {
		int number = -1;
		Scanner scanner = new Scanner(System.in);
		while (number <= 0) {
			System.out.print("Enter Valid value for retrieving nth element in fibonacci series : ");
			number = scanner.nextInt();
		}
		scanner.close();
		System.out.println();

		long start = System.currentTimeMillis();
		System.out.println("Recursively Fibonacci series " + number
				+ "th element : " + fibonacciRecursive(number));
		long end = System.currentTimeMillis();
		System.out.println("Time Taken by recursion : " + (end - start));
		System.out.println();

		start = System.currentTimeMillis();
		System.out.println("Non-Recursively Fibonacci series " + number
				+ "th element : " + fibonacciNonRecursive(number));
		end = System.currentTimeMillis();
		System.out.println("Time Taken by non-recursion : " + (end - start));
		System.out.println();

		int[] d = new int[number + 1];
		d[0] = -1; d[1] = 1; d[2] = 1;
		start = System.currentTimeMillis();
		System.out.println("Recursively Fibonacci series " + number
				+ "th element with memoization: " + fibMemoization(d, number));
		end = System.currentTimeMillis();
		System.out.println("Time Taken by non-recursion : " + (end - start));
		System.out.println();
		System.out.println("dictionary : " + Arrays.toString(d));
	}

	/**
	 * Time complexity : O(2^n)
	 * Tight bound will be golden ratio raised to n : O((1.68)^n)
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacciRecursive(final int n) {
		return ((n == 1 || n == 2) ? 1 : (fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)));
	}

	/**
	 * Time complexity : O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacciNonRecursive(final int n) {
		if (n == 1 || n == 2) { return 1; }
		int prev = 1, current = 1, next = 1;
		for (int i = 3; i <= n; i++) {
			next = prev + current;
			prev = current;
			current = next;
		}
		return next;
	}

	/**
	 * Time complexity : O(n)
	 * 
	 * @param d
	 * @param n
	 * @return
	 */
	public static int fibMemoization(int[] d, int n) {
		// check if its already calculated or not
		if (n > 0 && d[n] == 0) {
			// calculate it and save it for future reference
			d[n] = fibMemoization(d, n-1) + fibMemoization(d, n-2);
		}
		return d[n];
	}
}
