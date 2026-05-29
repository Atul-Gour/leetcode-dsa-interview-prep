class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 1;

        for( int i = 0 ; i < nums.length ; i++ ){
            maxJump--;
            maxJump = Math.max( maxJump , nums[i] );
            if( maxJump <= 0 && i != nums.length - 1 ) return false;
        }

        return true;
    }
}