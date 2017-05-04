package array.duplicates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find duplicates in given array ... 
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		String[] withDuplicates = new String[] { "one", "two", "three", "one", "two" };
		String[] withoutDuplicates = new String[] { "one", "two", "three" };

		System.out
				.println("Checking array with duplicate using brute force         : "
						+ bruteforce(withDuplicates));
		System.out
				.println("Checking array without any duplicate using brute force  : "
						+ bruteforce(withoutDuplicates));

		System.out
				.println("Checking array with duplicate using Set and List        : "
						+ checkDuplicateUsingSet(withDuplicates));
		System.out
				.println("Checking array without any duplicate using Set and List : "
						+ checkDuplicateUsingSet(withoutDuplicates));

		System.out
				.println("Checking array with duplicate using Set and List        : "
						+ checkDuplicateUsingAdd(withDuplicates));
		System.out
				.println("Checking array without any duplicate using Set and List : "
						+ checkDuplicateUsingAdd(withoutDuplicates));

		System.out
				.println("Find duplicate value in array with duplicate            : "
						+ findDuplicate(withDuplicates));
		System.out
				.println("Find duplicate value in array without duplicate         : "
						+ findDuplicate(withoutDuplicates));
		System.out
				.println("Find all duplicate values in array with duplicate       : "
						+ findAllDuplicate(withDuplicates));

	}

	/**
	 * brute force way of checking if array contains duplicates in Java
	 * comparing each elements to all other elements of array complexity on
	 * order of O(n^2) not advised in production
	 *
	 * @param input
	 * @return
	 */
	public static boolean bruteforce(final String[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i].equals(input[j]) && i != j) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * detect duplicate in array by comparing size of List and Set since Set
	 * doesn't contain duplicate, size must be less for an array which contains
	 * duplicates
	 *
	 * @param input
	 * @return
	 */
	public static boolean checkDuplicateUsingSet(final String[] input) {
		List<String> inputList = Arrays.asList(input);
		Set<String> inputSet = new HashSet<String>(inputList);
		if (inputSet.size() < inputList.size()) {
			return true;
		}
		return false;
	}

	/**
	 * Since Set doesn't allow duplicates add() return false if we try to add
	 * duplicates into Set and this property can be used to check if array
	 * contains duplicates.
	 *
	 * @param input
	 * @return
	 */
	public static boolean checkDuplicateUsingAdd(final String[] input) {
		Set<String> tempSet = new HashSet<String>();
		for (String str : input) {
			if (!tempSet.add(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds the specified element to this set if it is not already present. More
	 * formally, adds the specified element e to this set if the set contains no
	 * element e2 such that (e==null ? e2==null : e.equals(e2)). If this set
	 * already contains the element, the call leaves the set unchanged and
	 * returns false.
	 * 
	 * @param input
	 * @return
	 */
	public static String findDuplicate(final String[] input) {
		Set<String> tempSet = new HashSet<String>();
		for (String str : input) {
			if (!tempSet.add(str)) {
				return str;
			}
		}
		return null;
	}


	/**
	 * Adds the specified element to this set if it is not already present. More
	 * formally, adds the specified element e to this set if the set contains no
	 * element e2 such that (e==null ? e2==null : e.equals(e2)). If this set
	 * already contains the element, the call leaves the set unchanged and
	 * returns false.
	 * 
	 * @param input
	 * @return
	 */
	public static Set<String> findAllDuplicate(final String[] input) {
		Set<String> tempSet = new HashSet<String>();
		Set<String> duplicates = new HashSet<String>();
		for (String str : input) {
			if (!tempSet.add(str)) {
				duplicates.add(str);
			}
		}
		return duplicates;
	}

}
