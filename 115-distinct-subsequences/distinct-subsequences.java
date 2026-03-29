class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m  = t.length();

        if( n < m ) return 0;
        if( n == m ){
            if( s.equals(t) ) return 1;
            return 0;
        }

        int dp[][] = new int[n + 1][m + 1];

        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = m - 1 ; j >= 0 ; j-- ){
                int notTake = dp[i+1][j];
                int take = 0;

                if( s.charAt(i) == t.charAt(j) ){
                    if( j == m-1 ) take = 1;
                    else take = dp[i+1][j+1];
                } 

                dp[i][j] = take + notTake;
            }
        }

        return dp[0][0];
    }
}