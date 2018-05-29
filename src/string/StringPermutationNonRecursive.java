package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find all permutations of a String non-recursively
 *
 * @author "Jigar Gosalia"
 *
 */
public class StringPermutationNonRecursive {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String sample1 = "ABC";
		String sample2 = "123";
		System.out.println("\nPermutations <" + sample1 + ">: \n" + permutationFinder(sample1));
		System.out.println("\nPermutations <" + sample2 + ">: \n" + permutationFinder(sample2));
		System.out.println();
	}

	/**
	 * @param input
	 * @return
	 */
	public static Set<String> permutationFinder(final String input) {
		Set<String> permutation = new HashSet<String>();
		// Handling error scenarios
		if (input == null || input.length() == 0) {
			permutation.add("");
			return permutation;
		}
		// first character
		char firstCharacter = input.charAt(0);
		// Full string without first character
		String remainder = input.substring(1);
		Set<String> words = permutationFinder(remainder);
		for (String word : words) {
			for (int index = 0; index <= word.length(); index++) {
				permutation.add(insertCharacter(word, firstCharacter, index));
			}
		}
		return permutation;
	}

	/**
	 * @param input
	 * @param first
	 * @param index
	 * @return
	 */
	public static String insertCharacter(String input, char first, int index) {
		// Extract string till position "index", string from position "index"
		// and concatenate string (String till position "j" + character + String
		// from position "j")
		return input.substring(0, index) + first + input.substring(index);
	}
}
