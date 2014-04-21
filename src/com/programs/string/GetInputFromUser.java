package com.programs.string;

import java.util.Scanner;

/**
 * Get Input from User
 *
 * @author "Jigar Gosalia"
 *
 */
public class GetInputFromUser {

	/**
	 * @param args
	 */
	public static void main(final String args[]) {
		int integer;
		float floatValue;
		String string;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a string");
		string = scanner.nextLine();
		System.out.println("You entered string " + string);

		System.out.println("Enter an integer");
		integer = scanner.nextInt();
		System.out.println("You entered integer " + integer);

		System.out.println("Enter a float");
		floatValue = scanner.nextFloat();
		System.out.println("You entered float " + floatValue);
	}
}
