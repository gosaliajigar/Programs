package com.programs.power;

import java.util.Scanner;

/**
 * Check if the given number is power of 2
 *
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number to check if its power of 2 or not : ");

		int number = scanner.nextInt();

		System.out.println();

		System.out.println("isPowerOfTwo()-- is " + number
				+ " power of two :" + isPowerOfTwo(number));
		System.out.println("powerOfTwo()-- is " + number
				+ " power of two :" + powerOfTwo(number));
		System.out.println("checkPowerOfTwo()-- is " + number
				+ " power of two :" + checkPowerOfTwo(number));
	}

	/**
	 * Checking if number is power of 2 using bit shift operator in java
	 * e.g. 4 in binary format is "0000 0000 0000 0000 0000 0000 0000 0100"
	 *  and -4 is "1111 1111 1111 1111 1111 1111 1111 1100"
	 *  and 4&-4 will be "0000 0000 0000 0000 0000 0000 0000 0100"
	 *
	 * @param number
	 * @return
	 */
	private static boolean isPowerOfTwo(final int number) {
		if (number <= 0) {
			throw new IllegalArgumentException("number: " + number);
		}
		if ((number & -number) == number) {
			return true;
		}
		return false;
	}

	/**
	 * Checking if number is power of 2 using brute force starts with 1,
	 * multiplying with 2 it will eventually be same as original number
	 *
	 * @param number
	 * @return
	 */
	private static boolean powerOfTwo(final int number) {
		int square = 1;
		while (number >= square) {
			if (number == square) {
				return true;
			}
			square = square * 2;
		}
		return false;
	}

	/**
	 * Find if an integer number is power of 2 or not using bit shift operator
	 *
	 * @param number
	 * @return
	 */
	private static boolean checkPowerOfTwo(final int number) {
		if (number <= 0) {
			throw new IllegalArgumentException("number: " + number);
		}
		return ((number & (number - 1)) == 0);
	}
}
