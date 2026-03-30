class Solution {
    private int solve(int index, int buy, int transactions, int[] prices, int[][][] dp) {
        int n = prices.length;

        if (index == n || transactions == 2) return 0;

        if (dp[index][buy][transactions] != -1)
            return dp[index][buy][transactions];

        int profit = 0;

        if (buy == 1) {
            int take = -prices[index] + solve(index + 1, 0, transactions, prices, dp);
            int skip = solve(index + 1, 1, transactions, prices, dp);
            profit = Math.max(take, skip);
        } else {
            int take = prices[index] + solve(index + 1, 1, transactions + 1, prices, dp);
            int skip = solve(index + 1, 0, transactions, prices, dp);
            profit = Math.max(take, skip);
        }

        return dp[index][buy][transactions] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][2];

        for (int[][] arr2D : dp)
            for (int[] arr : arr2D)
                Arrays.fill(arr, -1);

        return solve(0, 1, 0, prices, dp);
    }
}