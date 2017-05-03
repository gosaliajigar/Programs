package com.programs.pascal.triangle;

import java.util.ArrayList;

/**
 * Print Pascal Triangle
 * 
 * @author "Jigar Gosalia"
 *
 */
public class PascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (ArrayList<Integer> row : generate(4)) {
			System.out.println(row);
		}
	}

	/**
	 * @param numRows
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (numRows <= 0)
			return result;

		ArrayList<Integer> previousRow = new ArrayList<Integer>();

		previousRow.add(1);

		result.add(previousRow);

		for (int i = 2; i <= numRows; i++) {
			ArrayList<Integer> currentRow = new ArrayList<Integer>();
			// first
			currentRow.add(1);
			// middle
			for (int j = 0; j < previousRow.size() - 1; j++) {
				currentRow.add(previousRow.get(j) + previousRow.get(j + 1));
			}
			// last
			currentRow.add(1);
			result.add(currentRow);
			previousRow = currentRow;
		}
		return result;
	}
}
