class Solution {
    public boolean canJump(int[] nums) {
        int canJump = nums[0];
        int n = nums.length;
        if(n == 1)return true;

        for(int i = 1 ; i < nums.length ; i++){
            if(canJump == 0)return false;
            if( i == nums.length - 1)return true;
            canJump--;

            canJump = Math.max(canJump , nums[i] );
        }
        return true;
    }
}  