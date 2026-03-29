class Solution {
    
    private int solve( int i , int j , String s , String t , int[][] dp ){
        int n = s.length();
        int m  = t.length();

        if( j == m || i == n ) return 0;

        if( dp[i][j] != -1 ) return dp[i][j];

        int notTake = solve( i + 1 , j , s , t , dp );
        int take = 0;

        if( s.charAt(i) == t.charAt(j) ){
            if( j == m-1 ) take = 1;
            else take = solve( i + 1 , j + 1 , s , t , dp );
        } 

        return dp[i][j] = take + notTake;
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m  = t.length();

        if( n < m ) return 0;
        if( n == m ){
            if( s.equals(t) ) return 1;
            return 0;
        }

        int dp[][] = new int[n][m];
        for( int[] arr : dp ) Arrays.fill( arr  , -1 );

        int ans = solve( 0 , 0 , s , t , dp );

        return ans;
    }
}