class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {
            for (int trans = 3 ; trans >= 0 ; trans--) {
                int profit = 0;

                    if (trans % 2 == 0) {
                        int take = -prices[i] + dp[i + 1][trans + 1];
                        int skip = dp[i + 1][trans];
                        profit = Math.max(take, skip);
                    } else {
                        int take = prices[i] + dp[i + 1][trans + 1];
                        int skip = dp[i + 1][trans];
                        profit = Math.max(take, skip);
                    }

                    dp[i][trans] = profit;
            }
            // int[][] temp = next;
            // next = curr;
            // curr = temp;
        }

        return dp[0][0];
    }
}