package array;

import java.util.Arrays;

/**
 * Shift array by constant k towards left.<br>
 * <br>
 * Shift array by constant (a.length - k) towards right.<br>
 * <br>
 * 
 * @author "Jigar Gosalia"
 *
 */
public class ShiftArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = a.clone();
		int[] c = a.clone();
		int k = 4;
		System.out.println(Arrays.toString(a));
		shiftNew(a, k);
		shiftBrute(b, k);
		shiftReversal(c, k);
		System.out.println();
		System.out.println("Shift Array(left) by <" + k + ">: " + Arrays.toString(a));
		System.out.println("Shift Array(left) by <" + k + ">: " + Arrays.toString(b));
		System.out.println("Shift Array(left) by <" + k + ">: " + Arrays.toString(c));
	}

	/**
	 * @param array
	 * @param k
	 */
	private static void shiftNew(int[] array, int k) {
		int[] result = new int[array.length];
		int location = k;
		for (int index = 0; index < array.length; index++) {
			// increment location by constant k and wrap around the array
			location = (index + k) % array.length;
			result[index] = array[location];
		}
		System.arraycopy(result, 0, array, 0, array.length);
	}

	/**
	 * @param array
	 * @param k
	 */
	private static void shiftBrute(int[] array, int k) {
		for (int i=0; i<k; i++) {
			int first = array[0];
			for (int index=0; index<array.length-1; index++) {
				array[index] = array[index+1];
			}
			array[array.length-1] = first;
		}
	}

	private static void shiftReversal(int[] array, int k) {
		k = k % array.length;
		reverse(array, 0, k);
		reverse(array, k, array.length);
		reverse(array, 0, array.length);
	}
	
	private static void reverse(int[] array, int start, int end) {
		int length = start+end;
		for (int i=start; i<length/2; i++) {
			int temp = array[i];
			array[i] = array[length-i-1];
			array[length-i-1] = temp;
		}
	}
}
