class Solution {

    private void swap( int[] nums , int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int i = 0;

        while( i <= r ){
            int curr = nums[i];

            if( curr == 1 ) i++;
            else if( curr == 0 ){
                swap( nums , i , l );
                l++;
                i++;
            }
            else{
                swap( nums , i , r );
                r--;
            }
            
        }
    }
}