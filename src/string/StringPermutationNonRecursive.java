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
			for (int i = 0; i <= string.length(); i++) {
				permutation.add(charInsert(string, firstCharacter, i));
			}
		}
		return permutation;
	}

	/**
	 * @param input
	 * @param c
	 * @param j
	 * @return
	 */
	public static String charInsert(String input, char c, int j) {
		// Extract String till position "j"
		String begin = input.substring(0, j);
		// Extract String from position "j"
		String end = input.substring(j);
		// Concatenate String (String till position "j" + character + String
		// from position "j")
		return begin + c + end;
	}
}
