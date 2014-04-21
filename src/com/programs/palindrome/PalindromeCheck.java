/**
 *
 */
package com.programs.palindrome;

/**
 * @author "Jigar Gosalia"
 *
 */
public class PalindromeCheck {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		System.out
				.println("Checking whether the following strings are Palindrome or not ... ");

		System.out.println();
		System.out.println("Using isPalindromeWithoutAnyOtherClass");
		System.out.println("--------------------------------------");
		System.out.println("Null         : " + isPalindromeWithoutAnyOtherClass(null));
		System.out.println("Empty String : "
				+ isPalindromeWithoutAnyOtherClass(""));
		System.out.println("a            : " + isPalindromeWithoutAnyOtherClass("a"));
		System.out.println("Hello        : "
				+ isPalindromeWithoutAnyOtherClass("Hello"));
		System.out.println("Hellooolleh  : "
				+ isPalindromeWithoutAnyOtherClass("Helloolleh"));
		System.out.println("HellooolleH  : "
				+ isPalindromeWithoutAnyOtherClass("HelloolleH"));

		System.out.println();
		System.out.println("Using isPalindromeWithStringBuilder");
		System.out.println("--------------------------------------");
		System.out.println("Null         : " + isPalindromeWithStringBuilder(null));
		System.out.println("Empty String : "
				+ isPalindromeWithStringBuilder(""));
		System.out.println("a            : " + isPalindromeWithStringBuilder("a"));
		System.out.println("Hello        : " + isPalindromeWithStringBuilder("Hello"));
		System.out.println("Hellooolleh  : "
				+ isPalindromeWithStringBuilder("Helloolleh"));
		System.out.println("HellooolleH  : "
				+ isPalindromeWithStringBuilder("HelloolleH"));

	}

	/**
	 * @param inputString
	 * @return
	 */
	public static boolean isPalindromeWithoutAnyOtherClass(
			final String inputString) {
		if (inputString == null) {
			return false;
		}

		if (inputString.length() <= 1) {
			return true;
		}

		// Note usage of toLowerCase as primitive char doesn't have any methods
		// to do that
		for (int i = 0; i <= inputString.length() / 2; i++) {
			if (inputString.toLowerCase().charAt(i) == inputString
					.toLowerCase().charAt(inputString.length() - i - 1)) {
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
	public static boolean isPalindromeWithStringBuilder(final String inputString) {
		if (inputString == null) {
			return false;
		}

		if (inputString.length() <= 1) {
			return true;
		}

		StringBuilder stringBuilder = new StringBuilder(inputString);
		stringBuilder.reverse();
		return stringBuilder.toString().equalsIgnoreCase(inputString);
	}
}
