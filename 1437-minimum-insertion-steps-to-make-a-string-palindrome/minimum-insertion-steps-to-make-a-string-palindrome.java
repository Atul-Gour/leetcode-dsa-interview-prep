class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int dp[][] = new int[n][n];

        for( int len = 1 ; len < n ; len++ ){
            for( int i = 0 ; i + len < n ; i++ ){
                int j = i + len;

                if( arr[i] == arr[j] ) dp[i][j] = dp[i + 1][j - 1];
                else dp[i][j] = Math.min( dp[i+1][j] , dp[i][j-1] ) + 1;
            }
        }

        return dp[0][n-1];
    }
}