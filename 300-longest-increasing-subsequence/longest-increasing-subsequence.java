class Solution {
    private int solve( int index , int prevIndex , int[] nums , int[][]dp ){
        int n = nums.length;
        if( index >= n || prevIndex >= n ) return 0;

        if( dp[index][prevIndex] != -1 ) return dp[index][prevIndex];

        int skip = solve( index + 1 , prevIndex , nums , dp );

        int take = 0;
        if( nums[prevIndex] < nums[index] ) take = 1 + solve( index + 1 , index , nums , dp );

        return dp[index][prevIndex] = Math.max( skip , take );
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n + 1];
        for( int i = 0 ; i < n ; i++ ) arr[i + 1] = nums[i];
        arr[0] = -10001;
        int[][] dp = new int[n+1][n+1];

        for( int[] a : dp ) Arrays.fill( a , -1 );

        return solve( 0 , 0 , arr , dp );
    }
}