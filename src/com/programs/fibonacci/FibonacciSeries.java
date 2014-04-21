package com.programs.fibonacci;

import java.util.Scanner;

/**
 * Find nth element in Fibonacci series using recursion
 *
 * @author "Jigar Gosalia"
 *
 */
public class FibonacciSeries {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		int number = -1;
		Scanner scanner = new Scanner(System.in);
		while (number <= 0) {
			System.out
					.print("Enter Valid value for retrieving n elements of fibonacci series : ");
			number = scanner.nextInt();
		}
		System.out.println();

		long start = System.currentTimeMillis();
		System.out.println("Recursively Fibonacci series " + number
				+ "th element : ");
		for (int i = 1; i <= number; i++) {
			System.out.print(fibonacciRecursive(i) + " ");
		}
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Time Taken by non-recursion : " + (end - start));
		System.out.println();

		start = System.currentTimeMillis();
		System.out.println("Non-Recursively Fibonacci series " + number
				+ "th element : ");
		for (int i = 1; i <= number; i++) {
			System.out.print(fibonacciNonRecursive(i) + " ");
		}
		end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Time Taken by non-recursion : " + (end - start));
	}

	/**
	 * @param number
	 * @return
	 */
	public static int fibonacciRecursive(final int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
	}

	/**
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
}
