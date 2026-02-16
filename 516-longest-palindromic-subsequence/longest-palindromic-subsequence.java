class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        char arr1[] = text1.toCharArray();
        char arr2[] = text2.toCharArray();
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n + 1][m + 1];

        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = m - 1 ; j >= 0 ; j-- ){
                if( arr1[i] == arr2[j] ){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j + 1] , dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }

    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence( s , s2 );

    }
}