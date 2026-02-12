class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int n = nums.length;
        int l = 0;
        long sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {

            sum += nums[r];

            while( sum >= k ){
                ans = Math.min(ans, r - l + 1 );
                sum -= nums[l];
                l++;
            }
        }

        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}