package dynamic;

import java.util.Arrays;

/**
 * Given coins, find total number of combinations possible to reach total sum.
 * source : https://www.geeksforgeeks.org/coin-change-dp-7/
 * 
 * @author "Jigar Gosalia"
 *
 */
public class CoinProblem {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3, 5 };
		int targetSum = 5;
		System.out.println(Arrays.toString(coins) + " combinations for sum<" + targetSum + ">: " + countCoinsUsingDFS(coins, coins.length, targetSum));
		System.out.println();
		System.out.println(Arrays.toString(coins) + " combinations for sum<" + targetSum + ">: " + countCoinsUsingDP(coins, targetSum));
	}

	public static int countCoinsUsingDFS(int[] coins, int coinCount, int targetSum) {
		// expected targetSum is ZERO
		if (targetSum == 0) return 1;

		// expected targetSum is less than ZERO
		// coinCount over and targetSum>=1 so no solution
		if (targetSum < 0 || (coinCount <= 0 && targetSum >= 1)) return 0;

		// total count is sum of 
		// (1). including coins[coinsCount - 1]
		// (2). excluding coins[coinsCount - 1]
		return countCoinsUsingDFS(coins, coinCount - 1, targetSum) + countCoinsUsingDFS(coins, coinCount, targetSum - coins[coinCount - 1]);
	}

	// time: mn space: n
	public static int countCoinsUsingDP(int[] coins, int targetSum) {
		if (targetSum == 0) return 0;
		int[] dp = new int[targetSum + 1];
		dp[0] = 1;
		// Pick all coins one by one
		// update the dp[] values after index greater than or equal to value of picked coin 
		for (int i = 0; i < coins.length; i++) {
			for (int j=coins[i]; j<=targetSum; j++) {
				dp[j] += dp[j-coins[i]];
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[targetSum];
	}
}
