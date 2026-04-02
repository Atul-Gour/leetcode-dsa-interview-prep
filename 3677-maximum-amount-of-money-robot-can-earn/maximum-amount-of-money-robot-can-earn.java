class Solution {

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        int[][][] dp = new int[n + 1][m + 1][3];

        for (int i = 0; i <= n; i++)
            for (int k = 0; k < 3; k++)
                dp[i][m][k] = Integer.MIN_VALUE;

        for (int j = 0; j <= m; j++)
            for (int k = 0; k < 3; k++)
                dp[n][j][k] = Integer.MIN_VALUE;

        if (coins[n - 1][m - 1] >= 0) {
            dp[n - 1][m - 1][0] = coins[n - 1][m - 1];
            dp[n - 1][m - 1][1] = coins[n - 1][m - 1];
            dp[n - 1][m - 1][2] = coins[n - 1][m - 1];
        } else {
            dp[n - 1][m - 1][0] = 0;
            dp[n - 1][m - 1][1] = 0;
            dp[n - 1][m - 1][2] = coins[n - 1][m - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int k = 2; k >= 0; k--) {
                    
                    if( i == n-1 && j == m-1 )continue;
                    int right = Integer.MIN_VALUE;
                    if (j + 1 < m) {
                        int next = dp[i][j + 1][k];
                        int take = (next == Integer.MIN_VALUE) ? Integer.MIN_VALUE : next + coins[i][j];

                        int skip = Integer.MIN_VALUE;
                        if (coins[i][j] < 0 && k < 2)
                            skip = dp[i][j + 1][k + 1];

                        right = Math.max(take, skip);
                    }

                    int down = Integer.MIN_VALUE;
                    if (i + 1 < n) {
                        int next = dp[i + 1][j][k];
                        int take = (next == Integer.MIN_VALUE) ? Integer.MIN_VALUE : next + coins[i][j];

                        int skip = Integer.MIN_VALUE;

                        if (coins[i][j] < 0 && k < 2)
                            skip = skip = dp[i + 1][j][k + 1];

                        down = Math.max(take, skip);
                    }

                    dp[i][j][k] = Math.max(right, down);
                }
            }
        }

        int ans = dp[0][0][0];

        return ans;

    }
}