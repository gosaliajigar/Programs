package com.programs.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find all permutations of a String
 *
 * @author "Jigar Gosalia"
 *
 */
public class StringPermutationRecursive {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String sample1 = "ABC";
		String sample2 = "123";
		System.out.println("\nPermutations for " + sample1 + " are: \n"
				+ permutationFinder(sample1));
		System.out.println("\nPermutations for " + sample2 + " are: \n"
				+ permutationFinder(sample2));
	}

	/**
	 * @param inputString
	 * @return
	 */
	public static Set<String> permutationFinder(final String inputString) {
		Set<String> permutation = new HashSet<String>();
		// Handling error scenarios
		if (inputString == null) {
			return null;
		} else if (inputString.length() == 0) {
			permutation.add("");
			return permutation;
		}
		// first character
		char firstCharacter = inputString.charAt(0);
		// Full string without first character
		String reminderString = inputString.substring(1);
		Set<String> words = permutationFinder(reminderString);
		for (String string : words) {
			for (int i = 0; i <= string.length(); i++) {
				permutation.add(charInsert(string, firstCharacter, i));
			}
		}
		return permutation;
	}

	/**
	 * @param inputString
	 * @param c
	 * @param j
	 * @return
	 */
	public static String charInsert(final String inputString, final char c, final int j) {
		// Extract String till position "j"
		String begin = inputString.substring(0, j);
		// Extract String from position "j"
		String end = inputString.substring(j);
		// Concatenate String (String till position "j" + character + String
		// from position "j")
		return begin + c + end;
	}
}
