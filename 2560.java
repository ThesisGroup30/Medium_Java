class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        
        // For k = 1, capability is simply the money in each house
        for (int i = 0; i < n; i++) {
            dp[i][1] = nums[i];
        }
        
        for (int j = 2; j <= k; j++) {
            for (int i = j - 1; i < n; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + nums[i]);
            }
        }
        
        return dp[n - 1][k];
    }
}
