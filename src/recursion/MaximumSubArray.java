package recursion;

import java.util.Arrays;

/**
 * 
 * Given a location in an array, maximum sub-array can be either on ...<br>
 * 1. Left side of location<br>
 * 2. Right side of location<br>
 * 3. Middle of location<br>
 * <br>
 * Hence divide and conquer the problem by finding maximum sub-array on both
 * sides of a location.<br>
 * <br>
 * Time complexity of finding maximum sub-array is O(nlogn).
 * 
 * @author Jigar Gosalia
 * 
 */
public class MaximumSubArray {

	/**
	 * Divide and Conquer problem by finding max sub-array either on left side,
	 * right side or middle of the given array.
	 * 
	 * @param values
	 * @param low
	 * @param high
	 * @return
	 */
	private static SubArray maxSubArray(int[] values, int low, int high) {
		if (low == high) {
			// base condition
			return new SubArray(low, high, values[low]);
		} else {
			int mid = (int) (low + high) / 2;
			// Check left side
			SubArray leftSubArray = maxSubArray(values, low, mid);
			// Check right side
			SubArray rightSubArray = maxSubArray(values, mid + 1, high);
			// Check from middle
			SubArray crossSubArray = maxCrossSubArray(values, low, mid, high);
			// Compare left, right and middle arrays to find maximum sub-array
			if (leftSubArray.getSum() >= rightSubArray.getSum()
					&& leftSubArray.getSum() >= crossSubArray.getSum()) {
				return leftSubArray;
			} else if (rightSubArray.getSum() >= leftSubArray.getSum()
					&& rightSubArray.getSum() >= crossSubArray.getSum()) {
				return rightSubArray;
			} else {
				return crossSubArray;
			}
		}
	}

	/**
	 * Find max sub-array by assuming the max sub-array occurs in middle of
	 * array.
	 * 
	 * @param values
	 * @param low
	 * @param mid
	 * @param high
	 * @return
	 */
	private static SubArray maxCrossSubArray(int[] values, int low, int mid,
			int high) {
		int sum = 0;
		int maxLeft = low;
		int maxRight = high;

		int leftSum = Integer.MIN_VALUE;
		for (int i = mid; i >= low; i--) {
			sum = sum + values[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}

		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for (int j = mid + 1; j <= high; j++) {
			sum = sum + values[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		SubArray max = new SubArray(maxLeft, maxRight, (leftSum + rightSum));
		return max;
	}

	/**
	 * Class to hold maximum sub-array details.
	 */
	static class SubArray {

		private int start;

		private int end;

		private int sum;

		public SubArray(int start, int end, int sum) {
			super();
			this.start = start;
			this.end = end;
			this.sum = sum;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "SubArray [start=" + start + ", end=" + end + ", sum=" + sum
					+ "]";
		}
	}

	public static final void main(String[] args) {
		int[] values = { 5, 15, -30, 10, -5, 40, 10 };
		System.out.println("Maximum sub-array for array"
				+ Arrays.toString(values) + ": " + maxSubArray(values, 0, 6));
	}

}
