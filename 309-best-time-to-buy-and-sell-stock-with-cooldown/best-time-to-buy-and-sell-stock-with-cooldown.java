class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {

            // buy = 1 → we can buy
            dp[i][1] = Math.max(
                -prices[i] + dp[i + 1][0],  // buy
                dp[i + 1][1]                // skip
            );

            // buy = 0 → we can sell
            dp[i][0] = Math.max(
                prices[i] + dp[i + 2][1],  // sell + cooldown
                dp[i + 1][0]               // skip
            );
        }

        return dp[0][1];
    }
}