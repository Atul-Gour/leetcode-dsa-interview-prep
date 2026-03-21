class Solution {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if( n <= 1 ) return false;
        int sum = 0;
        for( int ele : nums ) sum += ele;

        if( sum % 2 != 0 )return false;
        sum = sum/2;

        boolean[][] dp = new boolean[n][sum + 1];

        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for( int i = 0 ; i < n ; i++ ) dp[i][0] = true;
        
        for( int i = 1 ; i < n ; i++ ){
            for( int j = 1 ; j <= sum ; j++ ){
                if( j < nums[i] ) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][ j - nums[i] ] || dp[i-1][j];

            }
        }
        return dp[n-1][sum];
    }
}