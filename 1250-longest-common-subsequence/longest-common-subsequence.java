class Solution {

    int solve( int i , int j , String text1, String text2 , int dp[][] ){
        int n = text1.length();
        int m = text2.length();

        if( i >= n || j >= m )return 0;
        if( dp[i][j] != -1 )return dp[i][j];

        int ans = 0;

        if( text1.charAt(i) == text2.charAt(j) ){
            ans = Math.max( ans , 1 + solve( i + 1 , j + 1 , text1 , text2 , dp ) );
        }
        else{
            ans = Math.max( ans , solve( i , j + 1 , text1 , text2 , dp ) );
            ans = Math.max( ans , solve( i + 1 , j , text1 , text2 , dp ) );
        }

        return dp[i][j] = ans;        
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        for( int[] arr : dp ){
            Arrays.fill( arr , -1 );
        }

        return solve( 0 , 0 , text1 , text2 , dp );
    }
}