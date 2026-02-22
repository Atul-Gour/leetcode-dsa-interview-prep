class Solution {
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int left, int right) {
        // Base case
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int leftMax = divide(nums, left, mid);
        int rightMax = divide(nums, mid + 1, right);
        int crossMax = crossSum(nums, left, right, mid);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int crossSum(int[] nums, int left, int right, int mid) {
        int leftSum = Integer.MIN_VALUE;
        int total = 0;

        // Scan left
        for (int i = mid; i >= left; i--) {
            total += nums[i];
            leftSum = Math.max(leftSum, total);
        }

        int rightSum = Integer.MIN_VALUE;
        total = 0;

        // Scan right
        for (int i = mid + 1; i <= right; i++) {
            total += nums[i];
            rightSum = Math.max(rightSum, total);
        }

        return leftSum + rightSum;
    }
}