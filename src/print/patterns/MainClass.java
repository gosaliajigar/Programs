package print.patterns;

import java.util.Scanner;

/**
 * Print Pattern
 *
 * *
 * **
 * ***
 * **
 * *
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
		System.out.print("Enter the maximum length of the pattern : ");
		int length = scanner.nextInt();
		scanner.close();
		System.out.println();
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = length - 1; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
