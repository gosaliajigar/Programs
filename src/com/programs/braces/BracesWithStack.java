package com.programs.braces;

import java.util.Scanner;
import java.util.Stack;

/**
*
* Write Java code to validate the sequence of braces using Stack Data Structure
*
* @author "Jigar Gosalia"
*
*/
public class BracesWithStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String braces = "";
		String choice = "y";
		Scanner scanner = new Scanner(System.in);
		while (choice.equals("y")) {
			System.out.println();
			System.out
					.println("Enter sequence of braces to check its validity ... ");
			braces = scanner.nextLine();
			System.out.printf("Entered sequence of braces %s is : "
					+ (validateBraces(braces) ? "valid\n\n" : "invalid\n\n"),
					braces);
			System.out.println("Do you want to continue [y/n] ? ");
			choice = scanner.nextLine();
		}
		scanner.close();
	}

	/**
	 * Validate the sequence of braces
	 * 
	 * @param braces
	 * @return
	 */
	public static boolean validateBraces(String braces) {
		boolean valid = true;
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < braces.length(); i++) {
			if (braces.charAt(i) == '(') {
				stack.push("(");
			}
			if (braces.charAt(i) == ')') {
			  // Check stack before popping to avoid Exception
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					valid = false;
				}
			}
		}
		if (!stack.isEmpty()) {
			valid = false;
		}
		return valid;
	}
}
