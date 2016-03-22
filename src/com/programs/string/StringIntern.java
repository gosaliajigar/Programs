package com.programs.string;

/**
 * @author "Jigar Gosalia"
 *
 */
public class StringIntern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String interned = new String(new char[] { 'i', 'n', 't' }).intern();
		String notInterned = new String(new char[] { 'n', 'o', 't' });
		System.out.println("Case 1: " + isInterned(interned));
		System.out.println("Case 2: " + isInterned(new String(interned)));
		System.out.println("Case 3: " + isInterned(notInterned));
	}

	/**
	 * @param s
	 * @return
	 */
	public static boolean isInterned(String s) {
		return (new String(s)).intern() == s;
	}

}
