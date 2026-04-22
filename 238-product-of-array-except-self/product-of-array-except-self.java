class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        output[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            output[i] = output[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < n; i++) {
            output[i] *= left;
            left *= nums[i];
        }

        return output;
    }
}