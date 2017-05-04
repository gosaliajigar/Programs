package armstrong;
import java.util.Scanner;

/**
 * Check if the given number is Armstrong Number and print Armstrong Numbers
 * till a given range
 *
 * 371 is Armstrong number as 3*3*3 + 7*7*7 + 1*1*1 = 371
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

		System.out.print("Enter number to check is its Armstrong number : ");

		int number = scanner.nextInt();

		System.out.println();

		if (isArmstrongNumber(number)) {
			System.out.println("Entered number <" + number
					+ "> is Armstrong Number");
		} else {
			System.out.println("Entered number <" + number
					+ "> is not Armstrong Number");
		}

		System.out.println();

		System.out
				.print("Enter valid [0-999] range to get Armstrong number : ");

		int range = scanner.nextInt();

		while (range > 999) {
			System.out
					.print("Enter valid [0-999] range to get Armstrong number : ");
			range = scanner.nextInt();
			System.out.println();
		}

		scanner.close();

		printArmstrongNumberRange(range);
	}

	/**
	 * @param original
	 * @return
	 */
	private static boolean isArmstrongNumber(final int original) {

		int number = original;

		int result = 0;

		while (number != 0) {
			int reminder = number % 10;
			result = result + (reminder * reminder * reminder);
			number = number / 10;
		}

		if (result == original) {
			return true;
		}
		return false;
	}

	/**
	 * @param range
	 */
	private static void printArmstrongNumberRange(final int range) {
		for (int i = 0; i < range; i++) {
			if (isArmstrongNumber(i)) {
				System.out.print(i + " ");
			}
		}
	}
}
