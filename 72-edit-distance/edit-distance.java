class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];

        for( int j = 0 ; j <= m ; j++ ){
            dp[n][j] = m - j;
        }
        for( int i = 0 ; i <= n ; i++ ){
            dp[i][m] = n - i;
        }

        for( int i = n-1 ; i >= 0 ; i-- ){
            for( int j = m - 1 ; j >= 0 ; j-- ){
                int ans = Integer.MAX_VALUE;
                if( word1.charAt( i ) == word2.charAt( j ) ){
                    ans = dp[i + 1][ j + 1 ];
                }else{
                    ans = Math.min( ans , 1 + dp[i][j+1]  );
                    ans = Math.min( ans , 1 + dp[i+1][j]  );
                    ans = Math.min( ans , 1 + dp[i+1][j+1]  );
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
}