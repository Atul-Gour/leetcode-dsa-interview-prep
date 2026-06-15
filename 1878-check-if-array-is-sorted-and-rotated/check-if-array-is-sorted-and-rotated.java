class Solution {
    public boolean check(int[] nums) {
        int fault = 0;
        int n = nums.length;

        for( int i = 1 ; i < n ; i++ ){
            if( nums[i] < nums[i - 1] ) fault++;
        }

        if( fault == 0 ) return true;
        if( fault == 1 && nums[n - 1] <= nums[0] ) return true;

        return false;
    }
}