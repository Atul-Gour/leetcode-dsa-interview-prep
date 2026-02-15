class Solution {
    long solve(int i, int[] nums, int[] colors, long[] dp) {
        int n = nums.length;
        if (i >= n)return 0;
        if (dp[i] != -1)return dp[i];
        long ans ;
        long take = nums[i];
        long notTake = solve(i + 1, nums, colors, dp);
        if (i + 1 < n) {
            if (colors[i + 1] != colors[i]) {
                take += solve(i + 1, nums, colors, dp);
            } else {
                take += solve(i + 2, nums, colors, dp);
            }
        }
        ans =  Math.max(take, notTake);

        return dp[i] = ans;
    }

    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long dp[] = new long[n];
        Arrays.fill(dp, -1);
        return solve(0, nums, colors, dp);
    }
}