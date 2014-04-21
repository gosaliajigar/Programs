package com.programs.swap;

/**
 * @author "Jigar Gosalia"
 *
 */
public class SwapUsingAdditionSubtraction {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		int a = 2, b = 3;
		System.out.println("Swapping using Addition-Subtraction Operator ...");
		System.out.println("Before - a:" + a + " " + "b:" + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After  - a:" + a + " " + "b:" + b);

	}
}
