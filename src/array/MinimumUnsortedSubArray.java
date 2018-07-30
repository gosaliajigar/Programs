package array;

import java.util.Arrays;

/**
 * 
 * Source : https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 * 
 * @author Jigar Gosalia
 *
 */
public class MinimumUnsortedSubArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}));
		System.out.println(Arrays.toString(minUnsortedSubarray(new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60})));
		System.out.println();
		System.out.println(Arrays.toString(new int[] {0, 1, 15, 25, 6, 7, 30, 40, 50}));
		System.out.println(Arrays.toString(minUnsortedSubarray(new int[] {0, 1, 15, 25, 6, 7, 30, 40, 50})));
	}
	
	public static int[] minUnsortedSubarray(int[] a) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int s = 0, e = a.length-1;

		// scan from left to find location s < s+1
		for (s=0; s<a.length-1; s++) {
			if (a[s] > a[s+1]) break;
		}

		// full array sorted
		if (s == a.length-1) return new int[] {-1, -1} ;

		// scan from right to find location e < e-1
		for (e=a.length-1; e>0; e--) {
			if (a[e] < a[e-1]) break;
		}

		// find min and max in unsorted range s-e
		for (int i=s; i<=e; i++) {
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}

		// find any element that is > min 
		for (int i=0; i<s; i++) {
			if (a[i] > min) {
				s = i; break;
			}
		}

		// find any element that is < max 
		for (int i=a.length-1; i>e; i--) {
			if (a[i] < max) {
				e = i; break;
			}
		}

		return Arrays.copyOfRange(a, s, e+1);
	}
}
