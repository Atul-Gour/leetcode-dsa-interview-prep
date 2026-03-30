class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int trans = 1; trans >= 0; trans--) {

                    int profit = 0;

                    if (buy == 1) {
                        int take = -prices[i] + dp[i + 1][0][trans];
                        int skip = dp[i + 1][1][trans];
                        profit = Math.max(take, skip);
                    } else {
                        int take = prices[i] + dp[i + 1][1][trans + 1];
                        int skip = dp[i + 1][0][trans];
                        profit = Math.max(take, skip);
                    }

                    dp[i][buy][trans] = profit;
                }
            }
        }

        return dp[0][1][0];
    }
}