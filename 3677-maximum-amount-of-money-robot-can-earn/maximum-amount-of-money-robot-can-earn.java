class Solution {
    private int solve(int i, int j, int k, int[][] coins, int[][][] dp) {
        int n = coins.length;
        int m = coins[0].length;

        if (i >= n || j >= m)
            return Integer.MIN_VALUE;

        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] >= 0)
                return coins[i][j];
            else if (k < 2)
                return 0;
            else
                return coins[i][j];
        }

        if (dp[i][j][k] != Integer.MIN_VALUE)
            return dp[i][j][k];

        int right = Integer.MIN_VALUE;
        if (j + 1 < m) {
            int next = solve(i, j + 1, k, coins, dp);
            int take = (next == Integer.MIN_VALUE) ? Integer.MIN_VALUE : next + coins[i][j];

            int skip = Integer.MIN_VALUE;
            if (coins[i][j] < 0 && k < 2)
                skip = solve(i, j + 1, k + 1, coins, dp);

            right = Math.max(take, skip);
        }

        int down = Integer.MIN_VALUE;
        if (i + 1 < n) {
            int next = solve(i + 1, j, k, coins, dp);
            int take = (next == Integer.MIN_VALUE) ? Integer.MIN_VALUE : next + coins[i][j];

            int skip = Integer.MIN_VALUE;

            if (coins[i][j] < 0 && k < 2)
                skip = skip = solve(i + 1, j, k + 1, coins, dp);

            down = Math.max(take, skip);
        }

        return dp[i][j][k] = Math.max(right, down);

    }

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        int[][][] dp = new int[n][m][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int k = 2; k >= 0; k--) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        int ans = solve(0, 0, 0, coins, dp);

        return ans;

    }
}