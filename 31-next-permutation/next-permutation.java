class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: find breakpoint
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = findRightmostGreater(nums, i + 1, n - 1, nums[i]);
            swap(nums, i, j);
        }

        // Step 3: reverse suffix
        reverse(nums, i + 1, n - 1);
    }

    private int findRightmostGreater(int[] nums, int l, int r, int target) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > target) {
                ans = mid;    
                l = mid + 1; 
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}