class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {

                int profit = 0;

                if (buy == 1) {
                    int take = -prices[i] + dp[i + 1][1 - buy];
                    int skip = dp[i + 1][buy];
                    profit = Math.max(take, skip);
                } else {
                    int take = prices[i] + dp[i + 2][1 - buy];
                    int skip = dp[i + 1][buy];
                    profit = Math.max(take, skip);
                }

                dp[i][buy] = profit;

            }
        }

        return dp[0][1];
    }
}