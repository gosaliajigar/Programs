package com.programs.generics;

/**
 * Generic Methods
 *
 * @author "Jigar Gosalia"
 *
 */
public class GenericMethod {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Integer[] integerArray = { 1, 2, 3 };
		printArray(integerArray);

		Character[] characterArray = { 'a', 'b', 'c' };
		printArray(characterArray);

		System.out.println("Element at 0 : " + getElement(integerArray, 0));
		System.out.println("Element at 0 : " + getElement(characterArray, 0));

		concatenateStrings("first", 1);
	}

	/**
	 * Example with one Generic Type
	 *
	 * @param inputArray
	 */
	public static <T> void printArray(final T[] inputArray) {
		for (T element : inputArray) {
			System.out.println("element : " + String.valueOf(element));
		}
	}

	/**
	 * Example with one Generic Type with primitive types
	 *
	 * @param inputArray
	 * @param elementPosition
	 * @return
	 */
	public static <T> T getElement(final T[] inputArray,
			final int elementPosition) {
		T returnElement = inputArray[elementPosition];
		return returnElement;
	}

	/**
	 * Example with more than two Generic Types
	 *
	 * @param first
	 * @param last
	 */
	public static <T, E> void concatenateStrings(final T first, final E last) {
		System.out.println("Output is : " + first + last);
	}
}
