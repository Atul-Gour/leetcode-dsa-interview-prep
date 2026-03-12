class Solution {
    public int uniquePaths(int m, int n) {
        long[][] dp = new long[m][n];
        dp[m-1][n-1] = 1;
        for( int i = m-1 ; i >= 0 ; i-- ){
            for( int j = n-1 ; j >= 0 ; j-- ){
                long down = i + 1 < m ? dp[i+1][j] : 0;
                long right = j + 1 < n ? dp[i][j+1] : 0;
                dp[i][j] = dp[i][j] + right + down;
            }
        }
        
        return (int) dp[0][0];

    }
}
