package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jigar Gosalia
 *
 */
public class CombinationArray {

	public static void main(String[] args) {
		// we need set as internal structure to make sure we do not get repetitive numbers
		Set<Set<Integer>> results = new HashSet<Set<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		combinations(new int[] { 1, 2, 3 }, 0, current, results);
		results.forEach(System.out::println);
		results.clear();
		System.out.println();
		// if repetitive elements then use List<Set<Integer>>
		combinations(new int[] { 1, 2, 1 }, 0, current, results);
		results.forEach(System.out::println);
	}

	public static void combinations(int[] a, int start, List<Integer> current, Set<Set<Integer>> results) {
		if (current.size() == a.length) {
			results.add(new HashSet<Integer>(current));
			return;
		}
		for (int i = start; i < a.length; i++) {
			current.add(a[i]);
			combinations(a, i, current, results);
			current.remove(current.size() - 1);
		}
	}
}
