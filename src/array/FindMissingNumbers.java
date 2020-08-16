package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Find missing numbers such that 1 <= a[i] <= n (n = size of array)
 * 
 * @author Jigar Gosalia
 *
 */
public class FindMissingNumbers {

	public static void main(String[] args) {
		System.out.println(findMissing(new int[] { 1, 1 }));
		System.out.println(findMissing(new int[] { 4, 6, 2, 8, 1, 2, 4, 7 }));
		System.out.println(findMissing(new int[] { 3, 3, 3 }));
		System.out.println(findMissing(new int[] { 3, 3, 2 }));
		System.out.println(findMissing(new int[] { 2, 2, 2, 2, 2, 2, 2, 2 }));
	}

	public static Set<Integer> findMissing(int[] a) {
		if (a == null || a.length <= 1) return null;

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (a[Math.abs(a[i]) - 1] > 0) {
				a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
			}
		}
		
		System.out.println(Arrays.toString(a));
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) set.add(i + 1);
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) a[i] = -a[i];
		}
		
		return set;
	}
}
