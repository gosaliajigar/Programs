package pascal.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Print Pascal Triangle
 * 
 * @author "Jigar Gosalia"
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		for (List<Integer> row : generate(10)) {
			System.out.println(row);
		}
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0) return result;
		List<Integer> previousRow = new ArrayList<Integer>();
		previousRow.add(1);
		result.add(previousRow);
		for (int i = 2; i <= numRows; i++) {
			List<Integer> currentRow = new ArrayList<Integer>();
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
