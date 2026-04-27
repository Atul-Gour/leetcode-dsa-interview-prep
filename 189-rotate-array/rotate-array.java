class Solution {

    private void rotate( int[] nums , int left , int right ){
        while( left <= right ){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        rotate( nums , 0 , n - k - 1 );
        rotate( nums , n - k , n - 1 );
        rotate( nums , 0 , n-1 );
    }
}