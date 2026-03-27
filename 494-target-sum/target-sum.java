class Solution {
    private int solve(int index, int curr, int target, int[] nums, int[][] dp, int sum) {

        if (index == nums.length) {
            return curr == target ? 1 : 0;
        }

        int key = curr + sum;

        if (dp[index][key] != -1) return dp[index][key];

        int total = 0;

        total += solve(index + 1, curr + nums[index], target, nums, dp, sum);
        total += solve(index + 1, curr - nums[index], target, nums, dp, sum);

        return dp[index][key] = total;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int sum = 0;
        for (int num : nums) sum += num;

        int[][] dp = new int[n][2 * sum + 1];

        for (int[] arr : dp) Arrays.fill(arr, -1);

        return solve(0, 0, target, nums, dp, sum);
    }
}