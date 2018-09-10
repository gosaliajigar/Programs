package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jigar Gosalia
 *
 */
public class PermutationArray {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3 };
		List<int[]> results = new ArrayList<int[]>();
		System.out.println(Arrays.toString(a));
		System.out.println();
		permutations(a, 0, results);
		for (int[] row : results) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
		System.out.println(Arrays.toString(a));
	}

	public static void permutations(int[] a, int start, List<int[]> results) {
		if (start >= a.length) {
			results.add(a.clone());
			return;
		}
		for (int j=start; j<a.length; j++) {
			swap(a, start, j);
			permutations(a, start+1, results);
			swap(a, start, j);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
