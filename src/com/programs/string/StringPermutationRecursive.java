package com.programs.string;

/**
 * Java Program to find all permutations of a String recursively
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
		System.out.println("\nPermutations for " + sample1 + " are:");
		permutation(sample1);
		System.out.println();
		System.out.println("\nPermutations for " + sample2 + " are:");
		permutation(sample2);
		System.out.println();
	}

	/**
	 * @param str
	 */
	public static void permutation(String str) { 
	    permutation("", str);
	}

	/**
	 * @param prefix
	 * @param str
	 */
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	System.out.print(prefix + " ");
	    } else {
	    	for (int i = 0; i < n; i++) {
	    		permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    	}
	    }
	}
}
