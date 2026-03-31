class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length + 1;
        int arr[] = new int[n];
        for( int i = 0 ; i < n-1 ; i++ ) arr[i + 1] = nums[i];
        arr[0] = -10001;
        int[][] dp = new int[n+1][n+1];

        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = i-1 ; j >= 0 ; j-- ){

                int skip = dp[i+1][j];
                int take = 0;
                if( arr[j] < arr[i] ) take = 1 + dp[i+1][i];

                dp[i][j] = Math.max( skip , take );
            }
        }

        return dp[1][0];
    }
}