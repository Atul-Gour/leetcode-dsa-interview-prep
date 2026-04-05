class Solution {
    
    private int solve( int i , int j , int[] arr , int[][] dp ){

        if( i > j ) return 0;
        if( dp[i][j] != -1 ) return dp[i][j];
        int ans = 0;

        for( int k = i ; k <= j ; k++ ){
            int cost = solve( i , k - 1 , arr , dp ) +
                       solve( k + 1 , j , arr , dp ) + 
                       arr[i - 1] * arr[k] * arr[j + 1];      

            ans = Math.max( ans , cost );
        }

        return dp[i][j] = ans;
    }

    public int maxCoins(int[] nums) {
        int arr[] = new int[nums.length + 2];
        int n = arr.length;
        arr[0] = 1;
        arr[ n - 1 ] = 1;

        for( int i = 1 ; i < n - 1 ; i++ ){
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[n][n];
        for( int[] d: dp ) Arrays.fill( d , -1 );

        return solve( 1 , n - 2 , arr , dp );
    }
}