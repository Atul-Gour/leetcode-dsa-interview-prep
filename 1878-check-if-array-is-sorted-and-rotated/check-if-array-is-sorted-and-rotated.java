class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int index = 0;

        for( int i = 1 ; i < nums.length ; i++ ){
            if( nums[i - 1] > nums[i] ){
                count++;
                index = i;
            }
        }

        if( count > 1 ) return false;
        if( count == 0 ) return true;

        return nums[nums.length - 1] <= nums[0];
    }
}