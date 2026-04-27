class Solution {

    private void find(int[] nums, int index, int target) {

        int swapIndex = -1;

        // find first element from right > target
        for(int i = nums.length - 1; i >= index; i--) {
            if(nums[i] > target) {
                swapIndex = i;
                break; // ✅ important
            }
        }

        // swap
        int temp = nums[index - 1];
        nums[index - 1] = nums[swapIndex];
        nums[swapIndex] = temp;

        // reverse suffix
        reverse(nums, index, nums.length - 1);
    }

    private void reverse( int[] nums , int left , int right ){
        while( left < right ){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        for( int i = n-1 ; i > 0 ; i-- ){
            if( nums[i - 1] < nums[i] ){
                find( nums , i , nums[i - 1] );
                return ;
            }
        }

        reverse( nums , 0 , n - 1 );
    }
}