package Medium_Java;

import java.util.Stack;

public class _343 {
	public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j), j * dp[i - j]);
            }
        }

        return dp[n];
    }
}
