class Solution {
    private int solve(int i, int canBuy, int[] prices, int[][] dp) {
        if (i == prices.length) return 0;

        if (dp[i][canBuy] != -1) return dp[i][canBuy];

        int profit;

        if (canBuy == 1) {
            int buy = -prices[i] + solve(i + 1, 0, prices, dp);
            int skip = solve(i + 1, 1, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(i + 1, 1, prices, dp);
            int skip = solve(i + 1, 0, prices, dp);
            profit = Math.max(sell, skip);
        }

        return dp[i][canBuy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = 0 ; j <= 1 ; j++ ){

                int profit;

                if (j == 1) {
                    int buy = -prices[i] + dp[i + 1][0];
                    int skip = dp[i + 1][1];
                    profit = Math.max(buy, skip);
                } else {
                    int sell = prices[i] + dp[i + 1][1];
                    int skip = dp[i + 1][0];
                    profit = Math.max(sell, skip);
                }

                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }
}