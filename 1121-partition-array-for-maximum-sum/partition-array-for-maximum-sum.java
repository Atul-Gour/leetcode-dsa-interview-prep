class Solution {
    private int solve( int i , int j , int k , int[] arr , int[][] dp ){
        if( i > j ) return 0;
        if( dp[i][j] != -1 ) return dp[i][j];

        int maxValue = 0;
        int ans = 0;

        for( int step = 0 ; step < k   ; step++ ){
            if( i + step > j )continue;
            maxValue = Math.max( maxValue , arr[i + step] );

            int profit = ((step + 1) * maxValue) + solve( i + step + 1 , j , k , arr , dp );
            ans = Math.max( profit , ans );
        }

        return dp[i][j] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[][] = new int[n][n] ;
        for( int[] d : dp ) Arrays.fill( d , -1 );

        return solve( 0 , n - 1 , k , arr , dp );
    }
}