package recursion;

import java.util.Arrays;

/**
 * 
 * @author "Jigar Gosalia"
 * 
 */
public class MaximumSubArrayDynamicProgramming {

	public static int maxSubArrayNoSpace(int[] A) {
		int max = A[0];
		int newsum = A[0];
		for (int i = 1; i < A.length; i++) {
			newsum = Math.max(newsum + A[i], A[i]);
			max = Math.max(max, newsum);
		}
		return max;
	}

	public static int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}

	public static final void main(String[] args) {
		int[] values = { 5, -15, 30, 10, 15, -40, 10 };
		System.out.println("Max subarray           " + Arrays.toString(values) + ": " + maxSubArray(values));
		System.out.println("Max subarray (No Space)" + Arrays.toString(values) + ": " + maxSubArrayNoSpace(values));
	}

}
