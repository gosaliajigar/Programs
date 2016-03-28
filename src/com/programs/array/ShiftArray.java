package com.programs.array;

import java.util.Arrays;

/**
 * Shift array by constant k.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class ShiftArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 4;
		System.out.println(Arrays.toString(array));
		shift(array, k);
		System.out.println();
		System.out.println("Shift Array(left) by <" + k + ">: " + Arrays.toString(array));
	}

	/**
	 * @param array
	 * @param k
	 */
	private static void shift(int[] array, int k) {
		int[] result = new int[array.length];
		int location = k;
		for (int index = 0; index < array.length; index++) {
			// increment location by constant k and wrap around the array
			location = (index + k) % array.length;
			result[index] = array[location];
		}
		System.arraycopy(result, 0, array, 0, array.length);
	}
}
