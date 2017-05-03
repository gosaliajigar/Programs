package com.programs.array;

import java.util.Arrays;

/**
 * Copying Arrays <br>
 * 	1. System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)<br>
 *  2. Arrays.copyOf(char[] original, int newLength)<br>
 *  3. Object.clone()<br>
 *
 * @author "Jigar Gosalia"
 *
 */
public class CopyArray {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		char[] charArray = { 'a', 'b', 'c', 'd' };
		char[] systemArrayCopy = { 'e', 'f', 'g', 'h' };
		char[] arraysCopyOf;
		char[] cloneCharArray;

		System.out.println();
		System.out.println("charArrayCopy Address   : " + charArray);
		System.out.println("systemArrayCopy Address : " + systemArrayCopy);
		System.out.println();

		// System.arraycopy copies content from source array to destination array
		System.out.println("Using System.arraycopy");
		System.out.println("----------------------");
		System.out.println("Before - Copied Array   : "
				+ Arrays.toString(systemArrayCopy));
		System.arraycopy(charArray, 0, systemArrayCopy, 0, charArray.length);
		System.out.println("After - Copied Array    : "
				+ Arrays.toString(systemArrayCopy));
		System.out.println("charArray Address       : " + charArray);
		System.out.println("systemArrayCopy Address : " + systemArrayCopy);

		System.out.println();
		// Arrays.copyOf creates a new array and copies content from source
		// array to destination array. Internally it uses System.arraycopy
		System.out.println("Using Arrays.copyOf");
		System.out.println("-------------------");
		arraysCopyOf = Arrays.copyOf(charArray, 2);
		System.out.println("After - Copied Array    : "
				+ Arrays.toString(arraysCopyOf));
		System.out.println("charArray Address       : " + charArray);
		System.out.println("arraysCopyOf Address    : " + arraysCopyOf);

		System.out.println();
		// Object.clone creates copy of source array
		System.out.println("Using Object.clone");
		System.out.println("-------------------");
		cloneCharArray = charArray.clone();
		System.out.println("After - Copied Array    : "
				+ Arrays.toString(cloneCharArray));
		System.out.println("charArray Address       : " + charArray);
		System.out.println("cloneCharArray Address  : " + cloneCharArray);
	}
}
