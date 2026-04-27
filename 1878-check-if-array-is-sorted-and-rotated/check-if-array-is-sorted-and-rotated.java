class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int index = 0;

        for( int i = 1 ; i < nums.length ; i++ ){
            if( nums[i - 1] > nums[i] ){
                count++;
                if( count == 1 ) index = i;
            }
        }

        if( count > 1 ) return false;
        if( count == 0 ) return true;

        int leftMin = nums[0];
        int rightMax = nums[nums.length - 1];

        if( rightMax <= leftMin ) return true;
        else return false;

    }
}