class Solution {
    private int find( int[] nums ){
        int n = nums.length;
        int dp[][] = new int[n][2];

        dp[0][0] = nums[0];

        for( int i = 1 ; i < n ; i++ ){
            dp[i][0] = dp[i-1][1] + nums[i] ;
            dp[i][1] = Math.max( dp[i-1][0] , dp[i-1][1] );
        }

        return Math.max(dp[n-1][0] , dp[n-1][1]);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 1 )return nums[0];

        return Math.max(find( Arrays.copyOfRange(nums, 0, n - 1) ) , find( Arrays.copyOfRange(nums, 1, n ) ));
    }
}