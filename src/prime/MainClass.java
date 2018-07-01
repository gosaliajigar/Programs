package prime;

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
		System.out.print("Enter number to check if its a PRIME number: ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();
		System.out.println();

		if (isPrime(number)) System.out.println("<" + number + "> is PRIME number");
		else System.out.println("<" + number + "> is not PRIME number");

		for (int i=0;i<100;i++) {
			System.out.println(i + " : " + isPrimeSR(i));
		}
	}

	/**
	 * @param number
	 * @return
	 */
	private static boolean isPrime(int number) {
		if (number == 0 || number == 1) return false;
		for (int i = 2; i <= number/2; i++) {
			if ((number % i) == 0) return false;
		}
		return true;
	}

	private static boolean isPrimeSR(int number) {
		if (number == 2) return true;
		if (number == 0 || number == 1 || number%2 == 0) return false;
		for (int i = 3; i*i <= number; i+=2) {
			if ((number % i) == 0) return false;
		}
		return true;
	}
}
