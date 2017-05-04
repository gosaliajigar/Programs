package braces;

import java.util.Scanner;

/**
 *
 * Write Java code to validate the sequence of braces
 *
 * @author "Jigar Gosalia"
 *
 */
public class Braces {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

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
	private static Boolean validateBraces(final String braces) {

		// count to keep track of opening and closing braces
		int count = 0;

		if (braces != null && !braces.isEmpty()) {
			// This condition is ONLY on assumption that input string has only
			// braces. If input string has characters other than braces then,
			// delete below condition.
			if (braces.length() % 2 != 0) {
				return false;
			}

			for (int i = 0; i < braces.length(); i++) {
				if (braces.charAt(i) == '(') {
					count++;
				} else if (braces.charAt(i) == ')') {
					count--;
				}
				// count < 0 means the braces are not in right order
				if (count < 0) {
					return false;
				}
			}

			// count != 0 means the braces are not even
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
}
