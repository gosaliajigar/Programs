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

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		int number = -1;
		Scanner scanner = new Scanner(System.in);
		while (number <= 0) {
			System.out
					.print("Enter Valid value for retrieving nth element in fibonacci series : ");
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
	 * @param number
	 * @return
	 */
	public static int fibonacciRecursive(final int number) {
		return ((number == 1 || number == 2) ? 1 : (fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2)));
	}

	/**
	 * Time complexity : O(n)
	 * 
	 * @param number
	 * @return
	 */
	public static int fibonacciNonRecursive(final int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		int prev = 1, current = 1, next = 1;
		for (int i = 3; i <= number; i++) {
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
		if (n == 0 || n == 1) {
			return n;
		} else {
			// check if its already calculated or not
			if (d[n] == 0) {
				// calculate it and save it for future reference
				d[n] = fibMemoization(d, n-1) + fibMemoization(d, n-2);
			}
			return d[n];
		}
	}
}
