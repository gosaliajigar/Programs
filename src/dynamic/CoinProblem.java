package dynamic;

import java.util.Arrays;

/**
 * Given coins, find total number of combinations possible to reach total sum.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class CoinProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = { 1, 2, 3, 5 };
		int sum = 5;
		System.out.println("Given " + Arrays.toString(coins) + ", possible combinations for sum<" + sum + ">: "
				+ coins(sum, coins, 0));
	}

	/**
	 * @param sum
	 * @param options
	 * @param option
	 * @return
	 */
	public static int coins(int sum, int[] options, int option) {
		// expected sum is less than ZERO
		if (sum < 0) return 0;

		// expected sum is ZERO
		if (sum == 0) return 1;

		// coins over and sum>0 so no solution
		if (option == options.length && sum > 0) return 0;

		// with option + without option
		return coins(sum - options[option], options, option)
				+ coins(sum, options, option + 1);
	}
}
