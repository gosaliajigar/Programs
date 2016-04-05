package com.programs.string;

/**
 * 
 * @author "Jigar Gosalia"
 *
 */
public class StringCombination {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String input = "ABC";
		combineRecursive(input, new StringBuffer(), 0);
	}

	/**
	 * @param in
	 * @param out
	 * @param index
	 */
	public static void combineRecursive(final String in,
			final StringBuffer out, final int index) {
		for (int i = index; i < in.length(); i++) {
			out.append(in.charAt(i));
			System.out.println(out);
			combineRecursive(in, out, i + 1);
			out.deleteCharAt(out.length() - 1);
		}
	}
}
