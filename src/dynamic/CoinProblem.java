package dynamic;

import java.util.Arrays;

/**
 * Given coins, find total number of combinations possible to reach total sum.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class CoinProblem {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3, 5 };
		int sum = 5;
		System.out.println(Arrays.toString(coins) + " combinations for sum<" + sum + ">: " + coins(sum, coins, 0));
		System.out.println(coins(sum, coins));
	}

	public static int coins(int sum, int[] coins, int coin) {
		// expected sum is less than ZERO
		if (sum < 0) return 0;

		// expected sum is ZERO
		if (sum == 0) return 1;

		// coins over and sum>0 so no solution
		if (coin == coins.length && sum > 0) return 0;

		// with option + without option
		return coins(sum - coins[coin], coins, coin) + coins(sum, coins, coin + 1);
	}

	public static int coins(int sum, int[] coins) {
		if (sum == 0) return 0;
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		for (int i = 0; i <= sum; i++) {
			for (int coin : coins) {
				if ((i + coin) <= sum) {
					dp[i + coin] += dp[i];
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[sum];
	}
}
