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
	 * @param instr
	 * @param outstr
	 * @param index
	 */
	public static void combineRecursive(final String instr,
			final StringBuffer outstr, final int index) {
		for (int i = index; i < instr.length(); i++) {
			outstr.append(instr.charAt(i));
			System.out.println(outstr);
			combineRecursive(instr, outstr, i + 1);
			outstr.deleteCharAt(outstr.length() - 1);
		}
	}
}
