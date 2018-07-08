package odd.even;

import java.util.Scanner;

/**
 * Find if number is odd or even using Bitwise AND Operator
 *
 * For Even numbers (XXX0 & 0001) = 0000
 * For Odd numbers (XXX1 & 0001) = 0001
 *
 * @author "Jigar Gosalia"
 *
 */
public class UsingBitwiseAnd {
	public static void main(final String[] args) {
		System.out.print("Enter the number to check if its odd or even : ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();
		StringBuilder displayString = new StringBuilder();
		displayString.append("Entered number <").append(number).append("> is ");
		if ((number & 1) == 0) {
			displayString.append("EVEN");
		} else {
			displayString.append("ODD");
		}
		System.out.println();
		System.out.println(displayString.toString());
	}
}
