class Solution {


    void swap( int[] nums , int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void moveZeroes(int[] nums) {

        int i = 0;
        int j = 0;
        int n = nums.length;

        while( i < n ){
            
            if( nums[i] != 0 ){
                i++;
                continue;
            }

            j = i + 1;

            while( j < n ){
                if( nums[j] == 0 ){
                    j++;
                    continue;
                }

                if( j >= n ) return;

                swap( nums ,i , j );
                break;
            }

            i++;
        }
    }
}