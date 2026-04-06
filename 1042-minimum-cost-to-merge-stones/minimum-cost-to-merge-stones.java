class Solution {
    private int solve( int i , int j , int k , int[] stones , int[][] dp , int[] prefix ){

        if( i == j ) return 0;
        if( dp[i][j] != -1 ) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        
        for( int m = i ; m < j ; m += (k - 1) ){
            int left = solve( i , m , k , stones , dp , prefix );
            int right = solve( m + 1 , j , k , stones , dp , prefix );

            ans = Math.min( ans , left + right );
        }

        if( (j - i) % (k - 1) == 0 ){
            ans += prefix[j + 1] - prefix[i];
        }
        
        return dp[i][j] = ans;
    }

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;

        int[] prefix = new int[n + 1];
        for( int i = 0 ; i < n ; i++ ) prefix[i + 1] = prefix[i] + stones[i];

        int dp[][] = new int[n][n];
        for( int[] d : dp )Arrays.fill( d , -1);

        int ans = solve( 0 , n - 1 , k , stones , dp , prefix );

        return ans;
    }
}