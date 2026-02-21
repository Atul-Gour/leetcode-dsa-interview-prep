class Solution {
    public long rob(int[] nums, int[] color) {
        int n = nums.length;
        long dp[] = new long[n+1];

        dp[n - 1] = nums[n-1];  

        for( int i = n - 2 ; i >= 0 ; i-- ){
            if( color[i] == color[i + 1] ){
                dp[i] = Math.max( nums[i] + dp[ i + 2 ] , dp[i + 1] );
            }
            else{
                dp[i] = nums[i] + dp[i + 1];
            }
        }

        return dp[0];
    }
}