package fibonacci;

import java.util.Scanner;

/**
 * Find nth element in Fibonacci series using recursion
 *
 * @author "Jigar Gosalia"
 *
 */
public class FibonacciSeries {

	public static void main(final String[] args) {
		int number = -1;
		Scanner scanner = new Scanner(System.in);
		while (number <= 0) {
			System.out.print("Enter Valid value for retrieving n elements of fibonacci series : ");
			number = scanner.nextInt();
		}
		scanner.close();
		System.out.println();

		long start = System.currentTimeMillis();
		System.out.println("Recursively Fibonacci series " + number
				+ "th element : ");
		for (int i = 1; i <= number; i++) {
			System.out.print(FibonacciNthElement.fibonacciRecursive(i) + " ");
		}
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Time Taken by non-recursion : " + (end - start));
		System.out.println();

		start = System.currentTimeMillis();
		System.out.println("Non-Recursively Fibonacci series " + number	+ "th element : ");
		for (int i = 1; i <= number; i++) {
			System.out.print(FibonacciNthElement.fibonacciNonRecursive(i) + " ");
		}
		end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Time Taken by non-recursion : " + (end - start));
	}
}
