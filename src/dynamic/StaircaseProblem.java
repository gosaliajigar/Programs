package dynamic;

/**
 * 1-2-3 how many pass of steps are there.
 * 
 * @author Jigar Gosalia
 *
 */
public class StaircaseProblem {

	public static void main(String[] args) {
		System.out.println(stairsRecursive(10));
		System.out.println(stairsMemoization(10));
		System.out.println(stairsDP(10));
		System.out.println(stairs(10));
	}
	
	// 3^n	n
	public static int stairsRecursive(int steps) {
		if (steps < 0) return 0;
		if (steps == 0) return 1; 
		return stairsRecursive(steps - 1) + stairsRecursive(steps - 2) + stairsRecursive(steps - 3); 
	}

	// n	n
	public static int stairsMemoization(int steps) {
		return stairsMemoization(steps, new int[steps+1]);
	}

	// n 	n
	public static int stairsMemoization(int steps, int[] memo) {
		if (steps < 0) return 0;
		if (steps == 0) return 1; 
		if (memo[steps] == 0) memo[steps] = stairsMemoization(steps - 1, memo) + stairsMemoization(steps - 2, memo) + stairsMemoization(steps - 3, memo);
		return memo[steps];
	}

	// n 	n
	public static int stairsDP(int steps) {
		if (steps < 0) return 0;
		if (steps == 0) return 1;
		int[] dp = new int[steps+1];
		dp[0] = 1; dp[1] = 1; dp[2] = 2;
		for (int i=3; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
		}
		return dp[steps];
	}

	// n 	1
	public static int stairs(int steps) {
		if (steps < 0) return 0;
		if (steps == 0) return 1;
		int[] dp = new int[] {1, 1, 2};
		for (int i=3; i<=steps; i++) {
			int count = dp[2] + dp[1] + dp[0];
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = count;
		}
		return dp[2];
	}
}
