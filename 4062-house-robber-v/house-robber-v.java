class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long dp[] = new long[n + 1];

        for( int i = n - 1 ; i >= 0 ; i-- ){
            long notTake = dp[i+1];
            long take = nums[i];

            if (i + 1 < n) {
                if (colors[i + 1] != colors[i]) {
                    take += dp[i+1];
                } else if( i + 2 < n) {
                    take += dp[i+2];
                }
            }

            dp[i] =  Math.max(take, notTake);
        }

        return dp[0];
    }
}