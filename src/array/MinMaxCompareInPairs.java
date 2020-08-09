package array;

/**
 * Find min and max integers in an array and find how many comparisons were done to find them.
 * 
 * If n is odd,  we perform 3(n/2) comparisons.
 * If n is even, we perform 1 initial comparison followed by (3n/2)-2 comparisons.
 * 
 * @author Jigar Gosalia
 *
 */
public class MinMaxCompareInPairs {

	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	public static int comparisons = 0;

	public static void main(String[] args) {
		compareInPairs(new int[] {1,2,3,4,5,1,2,3,2,3,2});
		min = Integer.MAX_VALUE; max = Integer.MIN_VALUE; comparisons = 0;
		compareInPairs(new int[] {1,2,3,4,5,1,2,3,2,3});
	}

	public static void compareInPairs(int[] a) {
		if (a == null || a.length == 0 || a.length == 1) return;
		if (a.length%2 == 1) { 
			min = max = a[0]; 
			comparisons += 0;
		} else {
			if (a[0] < a[1]) {
				min = a[0]; max = a[1];
			} else {
				min = a[1]; max = a[0];
			}
			comparisons += 1;
		}
		for (int i=((a.length%2==0) ? 2 : 1); i<a.length-1; i+=2) {
			if (a[i] < a[i+1]) {
				min = Math.min(a[i], min);
				max = Math.max(a[i+1], max);
			} else {
				min = Math.min(a[i+1], min);
				max = Math.max(a[i], max);
			}
			comparisons += 3;
		}
		System.out.println("n:" + a.length + ";min:" + min + ";max:" + max + ";c:" + comparisons);
	}
}
