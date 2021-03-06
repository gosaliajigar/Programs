package string;

import java.util.Scanner;

/**
 * Get Input from User
 *
 * @author "Jigar Gosalia"
 *
 */
public class GetInputFromUser {
	public static void main(final String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a string");
		String string = scanner.nextLine();
		System.out.println("You entered string " + string);

		System.out.println("Enter an integer");
		int integer = scanner.nextInt();
		System.out.println("You entered integer " + integer);

		System.out.println("Enter a float");
		float floatValue = scanner.nextFloat();
		System.out.println("You entered float " + floatValue);

		scanner.close();
	}
}
