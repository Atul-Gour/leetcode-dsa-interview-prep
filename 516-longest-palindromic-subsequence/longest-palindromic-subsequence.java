class Solution {
    public int longestPalindromeSubseq(String s) {
        return longCommSubstr( s , new StringBuilder(s).reverse().toString() );
    }
     public int longCommSubstr(String s1, String s2) {
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        
        int n = arr1.length;
        int m = arr2.length;
        
        int[][] dp = new int[n + 1][m + 1];
        
        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = m - 1 ; j >= 0 ; j-- ){
                if( arr1[i] == arr2[j] ){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }else{
                    dp[i][j] = Math.max( dp[i+1][j] , dp[i][j+1] );
                }
            }
        }
        
        return dp[0][0];
    }
}