package com.programs.fibonacci;

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
	}

	/**
	 * @param number
	 * @return
	 */
	public static int fibonacciRecursive(final int number) {
		if (number == 0 || number == 1) {
			return number;
		}
		return (fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2));
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
