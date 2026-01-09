class Solution {
    public long subArrayRanges(int[] nums) {

        long ans = 0;
        int n = nums.length;
        
        for(int i = 0 ;i < n-1 ; i++){
            int small = nums[i], big = nums[i];
            for(int j = i + 1 ; j < n ; j++){
                small = Math.min(small , nums[j]);
                big = Math.max( big , nums[j] );
                ans += ( big - small);
            }
        }
        return ans;
    }
}