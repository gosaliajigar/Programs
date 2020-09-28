package string;

import java.util.Arrays;

/**
 * @author Jigar Gosalia
 *
 */
public class StringReversal {

	public static void main(String[] args) {
		for (String word : Arrays.asList(null, "", "a", "ab", "abc", "hello how are you?")) {
			System.out.printf("%-20s : %-20s : %-20s\n", word, reverse(word), reverseRecursive(word));
		}
	}

	private static String reverseRecursive(String input) {
		return (input != null && input.length() > 1) 
				// recursive condition
				? reverseRecursive(input.substring(1)) + input.charAt(0) 
				// base condition
				: input;
	}

	private static String reverse(String input) {
		if (input != null && input.length() > 0) {
			char[] characters = input.toCharArray();
			for (int index = 0; index < input.length()/2; index++) {
				char temp = characters[index];
				characters[index] = characters[input.length() - 1 - index];
				characters[input.length() - 1 - index] = temp;
			}
			return new String(characters);
		}
		return input;
	}
}
