package com.programs.string;

/**
 *
 * Explains String.compareTo
 *
 * @author "Jigar Gosalia"
 *
 */
public class CompareStrings {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String lowerCase = "abcd";
		String upperCase = "ABCD";

		// A(65) precedes a(97); hence output is -ve
		System.out.println("Comparing " + upperCase + " with " + lowerCase
				+ " (case-sensitive)   : " + upperCase.compareTo(lowerCase));
		System.out.println();

		// a(97) follows A(65); hence output is +ve
		System.out.println("Comparing " + lowerCase + " with " + upperCase
				+ " (case-sensitive)   : " + lowerCase.compareTo(upperCase));
		System.out.println();

		System.out.println("Comparing " + lowerCase + " with " + upperCase
				+ " (case-insensitive) : "
				+ upperCase.compareToIgnoreCase(lowerCase));
		System.out.println();
	}
}
