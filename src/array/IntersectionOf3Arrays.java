package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Source :
 * https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
 * 
 * @author Jigar Gosalia
 *
 */
public class IntersectionOf3Arrays {
	public static void main(String[] args) {
		System.out.println(compare(new int[] {1, 5, 10, 20, 40, 80}, 
									new int[] {6, 7, 20, 80, 100}, 
									new int[] {3, 4, 15, 20, 30, 70, 80, 120}));
	}

	public static List<Integer> compare(int[] a, int[] b, int[] c) {
		List<Integer> results = new ArrayList<>();
		Arrays.sort(a); Arrays.sort(b); Arrays.sort(c);
		int i=0, j=0, k=0;
		while (i<a.length&&j<b.length&&k<c.length) {
			if (a[i] == b[j] && b[j] == c[k]) {
				results.add(a[i]); i++; j++; k++;
			} else if (a[i] < b[j]) { i++;
			} else if (b[j] < c[k]) { j++;
			} else { k++; }
			}
		return results;
	}
}
