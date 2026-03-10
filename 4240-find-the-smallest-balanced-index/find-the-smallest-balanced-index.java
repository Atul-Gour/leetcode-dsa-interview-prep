class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int x : nums) totalSum += x;

        long[] suffixProduct = new long[n];
        suffixProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (suffixProduct[i + 1] > totalSum / nums[i + 1]) {
                suffixProduct[i] = totalSum + 1;
            } else {
                suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
                if (suffixProduct[i] > totalSum) suffixProduct[i] = totalSum + 1;
            }
        }

        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == suffixProduct[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}