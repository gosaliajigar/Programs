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

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();

		System.out.print("Enetered number to check if its a PRIME number");

		System.out.println();

		if (checkPrime(number)) {
			System.out.println("Enetered number <" + number
					+ "> is PRIME number");
		} else {
			System.out.println("Enetered number <" + number
					+ "> is not PRIME number");
		}
	}

	/**
	 * @param number
	 * @return
	 */
	private static boolean checkPrime(final int number) {
		if (number == 0) {
			return false;
		}

		if (number == 1) {
			return true;
		}

		for (int i = 2; i < number / 2; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
