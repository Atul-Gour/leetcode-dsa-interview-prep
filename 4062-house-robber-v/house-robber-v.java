class Solution {

    public long rob(int[] nums, int[] colors) {

        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        long[] dp = new long[n];

        dp[0] = nums[0];

        if (colors[1] == colors[0]) {
            dp[1] = Math.max(nums[0], nums[1]);
        } else {
            dp[1] = nums[0] + nums[1];
        }

        for (int i = 2; i < n; i++) {

            long skip = dp[i - 1];
            long take;

            if (colors[i] == colors[i - 1]) {
                take = nums[i] + dp[i - 2];
            } else {
                take = nums[i] + dp[i - 1];
            }

            dp[i] = Math.max(skip, take);
        }

        return dp[n - 1];
    }
}