class Solution {

    private int solve( int i , int j , int[] arr , int[][] dp ){
        if( i == j ) return 0;
        if( dp[i][j] != -1 ) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        
        for( int k = i ; k < j ; k++ ){
            int a = solve( i , k , arr , dp );
            int b = solve( k + 1 , j , arr , dp );

            int c = arr[j] - arr[i - 1];

            ans = Math.min( ans , a + b + c );
        }

        return dp[i][j] = ans;

    }

    public int minCost(int n, int[] cuts) {
        
        Arrays.sort( cuts );
        int arr[] = new int[cuts.length + 2];
        for( int i = 0 ; i < cuts.length ; i++ ){
            arr[ i + 1 ] = cuts[i];
        }

        int nn = arr.length;
        int dp[][] = new int[nn][nn];
        for( int[] d : dp ) Arrays.fill( d , -1 );

        
        arr[ nn - 1 ] = n;

        return solve( 1 , nn - 1 , arr , dp );
    }
}