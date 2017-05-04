package dynamic;

import java.util.Arrays;

/**
 * Given no. of coins, find total number of combinations possible to reach the
 * total sum.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class CoinProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] denominations = { 1, 2, 3 };
		int sum = 5;
		System.out.println("Given " + Arrays.toString(denominations) + ", possible combinations for sum<" + sum + ">: "
				+ totalCombination(sum, denominations, 0));
	}

	/**
	 * @param sum
	 * @param noOfOptions
	 * @param option
	 * @return
	 */
	public static int totalCombination(int sum, int[] noOfOptions, int option) {
		// expected sum is less than ZERO
		if (sum < 0) {
			return 0;
		}

		// expected sum is ZERO
		if (sum == 0) {
			return 1;
		}

		// means coins over and n>0 so no solution
		if (option == noOfOptions.length && sum > 0) {
			return 0;
		}

		return totalCombination(sum - noOfOptions[option], noOfOptions, option)
				+ totalCombination(sum, noOfOptions, option + 1);
	}
}
