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
		if (input == null) {
			return null;
		} else if (input.length() == 0) {
			permutation.add("");
			return permutation;
		}
		// first character
		char firstCharacter = input.charAt(0);
		// Full string without first character
		String reminderString = input.substring(1);
		Set<String> words = permutationFinder(reminderString);
		for (String string : words) {
			for (int index = 0; index <= string.length(); index++) {
				permutation.add(insertCharacter(string, firstCharacter, index));
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
		// Extract String till position "index"
		String begin = input.substring(0, index);
		// Extract String from position "index"
		String end = input.substring(index);
		// Concatenate String (String till position "j" + character + String
		// from position "j")
		return begin + first + end;
	}
}
