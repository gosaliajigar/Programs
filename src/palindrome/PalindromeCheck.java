package palindrome;

import java.util.Arrays;

/**
 * @author "Jigar Gosalia"
 *
 */
public class PalindromeCheck {

	public static void main(final String[] args) {
		System.out.println("Checking whether the following strings are Palindrome or not ... ");

		System.out.println();
		System.out.println("Using isPalindrome");
		System.out.println("--------------------------------------");
		String nullString = null;
		System.out.println("Null         : " + isPalindrome(nullString));
		System.out.println("Empty String : " + isPalindrome(""));
		System.out.println("a            : " + isPalindrome("a"));
		System.out.println("Hello        : " + isPalindrome("Hello"));
		System.out.println("Hellooolleh  : " + isPalindrome("Helloolleh"));
		System.out.println("HellooolleH  : " + isPalindrome("HelloolleH"));

		System.out.println();
		System.out.println("Using isPalindromeStringUsingStringBuilder");
		System.out.println("--------------------------------------");
		System.out.println("Null         : " + isPalindromeStringUsingStringBuilder(nullString));
		System.out.println("Empty String : " + isPalindromeStringUsingStringBuilder(""));
		System.out.println("a            : " + isPalindromeStringUsingStringBuilder("a"));
		System.out.println("Hello        : " + isPalindromeStringUsingStringBuilder("Hello"));
		System.out.println("Hellooolleh  : " + isPalindromeStringUsingStringBuilder("Helloolleh"));
		System.out.println("HellooolleH  : " + isPalindromeStringUsingStringBuilder("HelloolleH"));

		System.out.println();
		System.out.println("Using isPalindromeRecursive");
		System.out.println("--------------------------------------");
		System.out.println("Null         : " + isPalindromeRecursive(nullString));
		System.out.println("Empty String : " + isPalindromeRecursive(""));
		System.out.println("a            : " + isPalindromeRecursive("a"));
		System.out.println("Hello        : " + isPalindromeRecursive("Hello"));
		System.out.println("Hellooolleh  : " + isPalindromeRecursive("Helloolleh"));
		System.out.println("HellooolleH  : " + isPalindromeRecursive("HelloolleH"));

	}

	/**
	 * @param inputArray
	 * @return
	 */
	public static boolean isPalindromeUsingCheckTillHalf(final char[] inputArray) {
		if (inputArray == null) return false;
		if (inputArray.length <= 1) return true;
		for (int i = 0; i <= inputArray.length/2; i++) {
			if (String.valueOf(inputArray[i]).equalsIgnoreCase(String.valueOf(inputArray[inputArray.length - i - 1]))) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param inputString
	 * @return
	 */
	public static boolean isPalindrome(final String inputString) {
		return (inputString != null) ? isPalindromeUsingCheckTillHalf(inputString.toCharArray()) : false;
	}

	/**
	 * @param inputArray
	 * @return
	 */
	public static boolean isPalindromeCharArrayUsingStringBuilder(final char[] inputArray) {
		return isPalindromeStringUsingStringBuilder(Arrays.toString(inputArray));
	}

	/**
	 * @param inputString
	 * @return
	 */
	public static boolean isPalindromeStringUsingStringBuilder(final String inputString) {
		if (inputString == null) return false;
		if (inputString.length() <= 1) return true;
		return new StringBuilder(inputString).reverse().toString().equalsIgnoreCase(inputString);
	}

	/**
	 * case sensitive recursive palindrome check
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isPalindromeRecursive(String input) {
		if (input == null || input.length() <= 1) {
			return true;
		}
		if (input.charAt(0) == input.charAt(input.length() - 1)) {
			return isPalindromeRecursive(input.substring(1, input.length()-1));
		}
		return false;
	}
}
