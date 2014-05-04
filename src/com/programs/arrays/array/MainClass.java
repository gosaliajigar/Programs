package com.programs.arrays.array;

/**
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		String[][] arrayOfArrays;
		// arrayOfArrays is a null reference to an array of String arrays
		// Trying arrayOfArrays.length already causes a NullPointerException,
		// like trying arrayOfArrays[0] does.
		arrayOfArrays = new String[1][];
		// arrayOfArrays now refers to an array of 1 null reference to a
		// String[].
		// arrayOfArrays.length is equal to 1.
		// arrayOfArrays[0] is null.
		arrayOfArrays[0] = new String[2];
		// arrayOfArrays now refers to an array of 1 non-null reference
		// to a String[] of length 2.
		// arrayOfArrays.length is still equal to 1.
		// arrayOfArrays[0].length is equal to 2 (but arrayOfArrays[0][0] and
		// arrayOfArrays[0][1] are both null).
		arrayOfArrays[0][0] = "Hello, World";
		arrayOfArrays[0][1] = "Good, Morning";
		// Now arrayOfArrays[0][0] and arrayOfArrays[0][1] are both non-null.

		// this creates a String[][] object like the one created
		// above, and assigns arrayOfArrays to refer to that object.
		// The whitespace is meant to emphasize that the
		// object created is an array of one String[] which
		// contains two Strings.
		String[][] shortHand = { { "Hello", "World" }, { "Good", "Morning" } };

		arrayOfArrays = new String[][] { { "Hello", "World" },
				{ "Good", "Morning" } };

		displayArray(shortHand);
		displayArray(arrayOfArrays);
	}

	/**
	 * @param array
	 */
	public static void displayArray(final Object[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("Row : " + i + " ");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
