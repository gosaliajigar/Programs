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
		Integer[] integerArray = { 1, 2, 3, 4 };
		String[] stringArray = { "Hi", "How", "are", "you", "?" };
		Boolean[] booleanArray = { 1 == 1, 2 == 3, 3 == 4, 5 == 5 };

		System.out.println("Character array : " + Arrays.toString(charArray));
		System.out.println("Interger array : " + Arrays.toString(integerArray));
		System.out.println("String array : " + Arrays.toString(stringArray));
		System.out.println("String array : " + Arrays.toString(booleanArray));
	}
}
