class Solution {

    private int find(int[] nums, int start, int end) {

        int rob = 0;
        int skip = 0;

        for(int i = start; i <= end; i++){
            int newRob = skip + nums[i];
            skip = Math.max(skip, rob);
            rob = newRob;
        }

        return Math.max(rob, skip);
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        return Math.max(
            find(nums, 0, n - 2),
            find(nums, 1, n - 1)
        );
    }
}