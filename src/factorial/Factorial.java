package factorial;

import java.util.Scanner;

/**
 * Find Factorial
 *
 * @author "Jigar Gosalia"
 *
 */
public class Factorial {

	public static void main(final String[] args) {
		int number = -1;
		Scanner scanner = new Scanner(System.in);
		while (number < 0) {
			System.out.print("Enter Valid Number for finding factorial (>=0) : ");
			number = scanner.nextInt();
		}
		scanner.close();
		long start = System.currentTimeMillis();
		System.out.println("Recursively : Factorial of " + "(" + number + ")   : " + factorialRecursive(number));
		long end = System.currentTimeMillis();
		System.out.println("Time Taken by recursion          : " + (end - start));
		start = System.currentTimeMillis();
		System.out.println("Non-Recursively Factorial of " + "(" + number + ") : " + factorialNonRecursive(number));
		end = System.currentTimeMillis();
		System.out.println("Time Taken by non-recursion      : " + (end - start));
	}

	// O(n)
	public static int factorialNonRecursive(int n) {
		int factorial = 1;
		while (n > 1) {
			factorial *= n;
			n--;
		}
		return factorial;
	}

	// O(n)
	public static int factorialRecursive(final int n) {
		return ((n == 0 || n == 1) ? 1 : (n * factorialRecursive(n - 1)));
	}
}
