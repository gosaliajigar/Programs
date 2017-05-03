package com.programs.searching;

/**
 * Interpolation search is an improved variant of binary search. This search
 * algorithm works on the probing position of required value. For this algorithm
 * to work properly the data collection should be in <b>sorted form and equally
 * distributed</b>.<br>
 * <br>
 * 
 * Even when the data is sorted, binary search does not take advantage of that
 * to probe the position of desired data.<br>
 * <br>
 * 
 * Interpolation search search a particular item by computing the probe
 * position. Initially probe position is the position of the middle most item of
 * the collection. <br>
 * <br>
 * 
 * Time Complexity : O(log(log n))
 * 
 * @author "Jigar Gosalia"
 *
 */
public class InterpolationSearch {

	public static int MAX_SIZE = 400;

	public static int[] array = new int[MAX_SIZE];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		populateData(array);
		interpolationSearch(array, 232);
	}

	/**
	 * @param array
	 * @param data
	 */
	private static void interpolationSearch(int[] array, int data) {
		int index = -1;
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int iterations = 0;
		int middle;

		while (lowerBound <= upperBound) {
			iterations++;
			middle = lowerBound + (((upperBound - lowerBound) / (array[upperBound] - array[lowerBound]))
					* (data - array[lowerBound]));
			// data is greater than value at middle, hence it is more towards
			// upperBound, so move lowerBound
			if (array[middle] < data) {
				lowerBound = middle + 1;
				// data is smaller than value at middle, hence it is more
				// towards lowerBound, so move upperBound
			} else if (array[middle] > data) {
				upperBound = middle - 1;
				// found data at middle
			} else {
				index = middle;
				break;
			}
		}
		System.out.println("No of Iterations             : " + iterations);
		System.out.println("Theoretical Iterations(log(log n)): "
				+ (Math.log((Math.log(array.length) / Math.log(2))) / Math.log(2)));
		if (index != -1) {
			System.out.println("Found " + data + " at location: " + index);
		} else {
			System.out.println("Couldn't find " + data);
		}
	}

	/**
	 * @param array
	 */
	private static void populateData(int[] array) {
		for (int index = 0; index < array.length; index++) {
			array[index] = 2 * index;
		}
	}
}
