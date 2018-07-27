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
		System.out.println("Using isPalindromeSB");
		System.out.println("--------------------------------------");
		System.out.println("Null         : " + isPalindromeSB(nullString));
		System.out.println("Empty String : " + isPalindromeSB(""));
		System.out.println("a            : " + isPalindromeSB("a"));
		System.out.println("Hello        : " + isPalindromeSB("Hello"));
		System.out.println("Hellooolleh  : " + isPalindromeSB("Helloolleh"));
		System.out.println("HellooolleH  : " + isPalindromeSB("HelloolleH"));

		System.out.println();
		System.out.println("Using isPalindromeR");
		System.out.println("--------------------------------------");
		System.out.println("Null         : " + isPalindromeR(nullString));
		System.out.println("Empty String : " + isPalindromeR(""));
		System.out.println("a            : " + isPalindromeR("a"));
		System.out.println("Hello        : " + isPalindromeR("Hello"));
		System.out.println("Hellooolleh  : " + isPalindromeR("Helloolleh"));
		System.out.println("HellooolleH  : " + isPalindromeR("HelloolleH"));

	}

	/**
	 * @param inputArray
	 * @return
	 */
	public static boolean isPalindrome(final char[] inputArray) {
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
		return (inputString != null) ? isPalindrome(inputString.toCharArray()) : false;
	}

	/**
	 * @param inputArray
	 * @return
	 */
	public static boolean isPalindromeSB(final char[] inputArray) {
		return isPalindromeSB(Arrays.toString(inputArray));
	}

	/**
	 * @param inputString
	 * @return
	 */
	public static boolean isPalindromeSB(final String inputString) {
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
	public static boolean isPalindromeR(String input) {
		if (input != null) {
			if (input.length() <= 1) {
				return true;
			} else if (input.length() == 2 || input.length() == 3) {
				return (input.charAt(0) == input.charAt(input.length() - 1));
			}
			if (input.charAt(0) == input.charAt(input.length() - 1)) {
				return isPalindromeR(input.substring(1, input.length()-1));
			}
		}
		return false;
	}
}
