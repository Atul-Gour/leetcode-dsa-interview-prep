class Solution {
    private int solve( int i , int j , String text1, String text2 , int[][] dp ){
        int n = text1.length();
        int m = text2.length();

        if( i == n )return dp[i][j] = m - j;
        if( j == m )return dp[i][j] = n - i;
        if( dp[i][j] != -1 ) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        if( text1.charAt(i) == text2.charAt(j) ) return dp[i][j] = solve( i + 1 , j + 1 , text1 , text2 , dp );
        
        ans = Math.min( ans , solve( i + 1 , j , text1 , text2 , dp ) + 1 );
        ans = Math.min( ans , solve( i , j + 1 , text1 , text2 , dp ) + 1 );
        ans = Math.min( ans , solve( i + 1 , j + 1 , text1 , text2 , dp ) + 2 );

        return dp[i][j] = ans;
    }

    public int minDistance(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n + 1][m + 1];
        for( int[] arr : dp )Arrays.fill( arr , -1 );

        return solve( 0 , 0 , text1 , text2 , dp );
    }
}