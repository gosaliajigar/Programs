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
		// Initialize with values
		char[] charArray = { 'a', 'b', 'c', 'd' };
		int[] intArray = { 1, 2, 3, 4 };
		boolean[] boolArray = { 1 == 1, 2 == 3, 3 == 4, 5 == 5 };

		System.out.println("char array    : " + Arrays.toString(charArray));
		System.out.println("int array     : " + Arrays.toString(intArray));
		System.out.println("boolean array : " + Arrays.toString(boolArray));

		// default values
		charArray = new char[5];
		intArray = new int[5];
		boolArray = new boolean[5];

		System.out.println("char array    : " + Arrays.toString(charArray));
		System.out.println("int array     : " + Arrays.toString(intArray));
		System.out.println("boolean array : " + Arrays.toString(boolArray));

		// Initialize with values
		String[] stringArray = { "Hi", "How", "are", "you", "?" };
		System.out.println("String array  : " + Arrays.toString(stringArray));

		// default values
		stringArray = new String[5];
		System.out.println("String array    : " + Arrays.toString(stringArray));

		// Initialize with values
		Character[] characterArray = { 'a', 'b', 'c', 'd' };
		Integer[] integerArray = { 1, 2, 3, 4 };
		Boolean[] booleanArray = { 1 == 1, 2 == 3, 3 == 4, 5 == 5 };

		System.out.println("Character array : " + Arrays.toString(characterArray));
		System.out.println("Interger array  : " + Arrays.toString(integerArray));
		System.out.println("Boolean array   : " + Arrays.toString(booleanArray));

		// default values
		characterArray = new Character[5];
		integerArray = new Integer[5];
		booleanArray = new Boolean[5];

		System.out.println("Character array : " + Arrays.toString(characterArray));
		System.out.println("Interger array  : " + Arrays.toString(integerArray));
		System.out.println("Boolean array   : " + Arrays.toString(booleanArray));
	}
}
