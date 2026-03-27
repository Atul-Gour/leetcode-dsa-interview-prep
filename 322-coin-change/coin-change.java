class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        Arrays.fill(dp[0] , Integer.MAX_VALUE);

        dp[0][0] = 0;

        for( int i = 1 ; i <= amount ; i++ ){
            if( i >= coins[0] && dp[0][i-coins[0]] != Integer.MAX_VALUE ){
                dp[0][i] = dp[0][i-coins[0]] + 1;
            }
        }

        for( int i = 1 ; i < n ; i++ ){
            for( int j = 0 ; j <= amount ; j++ ){
                if( j < coins[i] ){
                    dp[i][j] =  dp[i-1][j]; 
                }else{
                    dp[i][j] = Math.min( dp[i-1][j] , dp[i][j - coins[i]] + ( dp[i][j - coins[i]] == Integer.MAX_VALUE ? 0 : 1 ) ) ;
                }
            }
        }

        return dp[n-1][amount] == Integer.MAX_VALUE ? -1 : dp[n-1][amount];

    }
}