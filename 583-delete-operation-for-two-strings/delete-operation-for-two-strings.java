class Solution {
    public int minDistance(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n + 1][m + 1];

        for( int i = 0 ; i <= n ; i++ ) dp[i][m] = n - i;
        for( int j = 0 ; j <= m ; j++ ) dp[n][j] = m - j;
        
        for( int i = n-1 ; i >= 0 ; i-- ){
            for( int j = m-1 ; j >= 0 ; j-- ){

                if( text1.charAt(i) == text2.charAt(j) ){
                    dp[i][j] = dp[i+1][j+1];
                    continue;
                }

                int ans = Integer.MAX_VALUE;
                ans = Math.min( ans , dp[i+1][j] + 1 );
                ans = Math.min( ans , dp[i][j+1] + 1 );
                ans = Math.min( ans , dp[i+1][j+1] + 2 );

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }
}