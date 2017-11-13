package power;

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

		scanner.close();

		System.out.println();

		System.out.println("usingMinusPowerOfTwo()         -- is " + number + " power of two :" + usingMinusPowerOfTwo(Math.abs(number)));
		System.out.println("usingBruteForcePowerOfTwo()    -- is " + number  + " power of two :" + usingBruteForcePowerOfTwo(Math.abs(number)));
		System.out.println("usingShiftOperatorPowerOfTwo() -- is " + number + " power of two :" + usingShiftOperatorPowerOfTwo(Math.abs(number)));
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
	private static boolean usingMinusPowerOfTwo(final int number) {
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
	private static boolean usingBruteForcePowerOfTwo(final int number) {
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
	private static boolean usingShiftOperatorPowerOfTwo(final int number) {
		if (number <= 0) {
			throw new IllegalArgumentException("number: " + number);
		}
		return ((number & (number - 1)) == 0);
	}
}
