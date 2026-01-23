class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort( coins );
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = j / coins[0];
            else
                dp[0][j] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {

                int notTake = dp[i - 1][j];
                int take = -1;

                if (j >= coins[i] && dp[i][j - coins[i]] != -1) {
                    take = dp[i][j - coins[i]] + 1;
                }

                if (take == -1)
                    dp[i][j] = notTake;
                else if (notTake == -1)
                    dp[i][j] = take;
                else
                    dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[n-1][amount];
    }
}