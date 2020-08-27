package odd.even;

import java.util.Scanner;

/**
 * Find if number is odd or even using modulus
 *
 * @author "Jigar Gosalia"
 *
 */
public class UsingModulus {
	public static void main(final String[] args) {
		System.out.print("Enter the number to check if its odd or even : ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();
		StringBuilder displayString = new StringBuilder();
		displayString.append("Entered number <").append(number).append("> is ");
		displayString.append((number % 2 == 0) ? "EVEN" : "ODD");
		System.out.println();
		System.out.println(displayString.toString());
	}
}
