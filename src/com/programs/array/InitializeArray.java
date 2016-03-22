package com.programs.array;

import java.util.Arrays;

/**
 *
 * Write code to initialize and display Arrays
 *
 * @author "Jigar Gosalia"
 *
 */
public class InitializeArray {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		char[] charArray = { 'a', 'b', 'c', 'd' };
		int[] intArray = { 1, 2, 3, 4 };
		boolean[] boolArray = { 1 == 1, 2 == 3, 3 == 4, 5 == 5 };

		System.out.println("char array    : " + Arrays.toString(charArray));
		System.out.println("int array     : " + Arrays.toString(intArray));
		System.out.println("boolean array : " + Arrays.toString(boolArray));

		String[] stringArray = { "Hi", "How", "are", "you", "?" };
		System.out.println("String array  : " + Arrays.toString(stringArray));

		Character[] characterArray = new Character[5];
		Integer[] integerArray = new Integer[5];
		Boolean[] booleanArray = new Boolean[5];

		System.out.println("Character array : " + Arrays.toString(characterArray));
		System.out.println("Interger array  : " + Arrays.toString(integerArray));
		System.out.println("Boolean array   : " + Arrays.toString(booleanArray));

		stringArray = new String[5];
		System.out.println("String array    : " + Arrays.toString(stringArray));
	}
}
