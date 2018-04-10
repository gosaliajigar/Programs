package string;

import java.util.StringTokenizer;

/**
 * StringTokenizer for splitting String, it is legacy class and faster than split.<br>
 * <br>
 * Doesn't allow regex but allows single delim.
 *
 * @author "Jigar Gosalia"
 *
 */
public class Stringtokenizer {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		String line = "I am a java developer";

		System.out.println("Input String                     : " + line);
		System.out.println();

		tokenizeString(line, " ");
		System.out.println();

		// split string delimited with special characters
		String wordsWithPipe = "I|am|a|java|developer";
		tokenizeString(wordsWithPipe, "|");
		System.out.println();

		String wordsWithForwardSlash = "I/am/a/java/developer";
		tokenizeString(wordsWithForwardSlash, "/");
		System.out.println();

		String wordsWithDot = "I.am.a.java.developer";
		tokenizeString(wordsWithDot, ".");
		System.out.println();

		String wordsWithBackwardSlash = "I\\am\\a\\java\\developer";
		tokenizeString(wordsWithBackwardSlash, "\\");
		System.out.println();
	}

	/**
	 * @param line
	 * @param delimiter
	 */
	private static void tokenizeString(final String line, final String delimiter) {
		System.out.print("String split with delimiter (" + delimiter + " ) : ");
		StringTokenizer stringTokenizer = new StringTokenizer(line, delimiter);
		while (stringTokenizer.hasMoreTokens()) {
			System.out.print(stringTokenizer.nextToken() + " ");
		}
		System.out.println();
	}
}
