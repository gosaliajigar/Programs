package com.programs.prime;

import java.util.Scanner;

/**
 * Find if the given number is Prime
 *
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		System.out.print("Enter number to check if its a PRIME number: ");

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();

		scanner.close();

		System.out.println();

		if (checkPrime(number)) {
			System.out.println("Entered number <" + number
					+ "> is PRIME number");
		} else {
			System.out.println("Entered number <" + number
					+ "> is not PRIME number");
		}
	}

	/**
	 * @param number
	 * @return
	 */
	private static boolean checkPrime(final int number) {
		if (number == 0 || number == 1) {
			return false;
		}

		for (int i = 2; i < number / 2; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
