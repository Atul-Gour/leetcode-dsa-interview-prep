class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        boolean dp[][] = new boolean[n + 1][n + 1];

        dp[n][0] = true;
        
        for( int i = n - 1 ; i >= 0; i-- ){
            for(int j = 0; j <= n; j++){
                char ch = s.charAt(i);

                if( ch == '(' ) {if( j + 1 <= n )dp[i][j] = dp[i+1][j+1];}
                else if( ch == ')' ) {if( j - 1 >= 0 )dp[i][j] = dp[i+1][j-1];}
                else {
                    dp[i][j] = dp[i+1][j] || j - 1 >= 0 && dp[i+1][j-1] || (j + 1 <= n) && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}