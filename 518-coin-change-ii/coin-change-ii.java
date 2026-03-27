class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        dp[0][0] = 1;

        for( int j = 1 ; j <= amount ; j++ ){
            if( j >= coins[0] ) dp[0][j] = dp[0][ j - coins[0] ];
        }

        for( int i = 1 ; i < n ; i++ ){
            for( int j = 0 ; j <= amount ; j++ ){
                dp[i][j] += dp[i-1][j];
                if( j >= coins[i] ) dp[i][j] += dp[i][ j - coins[i] ];
            }
        }

        return dp[n-1][amount];
    }
}