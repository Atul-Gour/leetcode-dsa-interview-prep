class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while( l < r ){
            int sum = nums[l] + nums[r];

            if( sum == k ){
                l++;
                r--;
                ans++;
            }
            else if( sum < k ){
                l++;
            }
            else r--;
        }

        return ans;
    }
}