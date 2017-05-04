package string;

import java.util.Arrays;

/**
 *
 * This program shows how to split a string in java
 *
 * @author "Jigar Gosalia"
 *
 */
public class StringSplit {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String line = "I am a java developer";

		System.out.println("Input String                            : " + line);
		System.out.println();

		String[] words = line.split(" ");
		System.out.println("String split with delimiter         ( ) : "
				+ Arrays.toString(words));
		System.out.println();

		String[] twoWords = line.split(" ", 2);
		System.out.println("String split into two               ( ) : "
				+ Arrays.toString(twoWords));
		System.out.println();

		// split string delimited with special characters
		String wordsWithPipe = "I|am|a|java|developer";
		String[] numbers = wordsWithPipe.split("\\|");
		System.out.println("String split with special character (|) : "
				+ Arrays.toString(numbers));
		System.out.println();

		String wordsWithForwardSlash = "I/am/a/java/developer";
		System.out.println("String split with special character (/) : "
				+ Arrays.toString(wordsWithForwardSlash.split("/")));
		System.out.println();

		String wordsWithDot = "I.am.a.java.developer";
		System.out.println("String split with special character (.) : "
				+ Arrays.toString(wordsWithDot.split("\\.")));
		System.out.println();

		String wordsWithBackwardSlash = "I\\am\\a\\java\\developer";
		System.out.println("String split with special character (\\) : "
				+ Arrays.toString(wordsWithBackwardSlash.split("\\\\")));
	}
}