class Solution {

    private void swap( int[] nums , int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse( int[] nums , int i , int j ){
        while( i < j ){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;

        if( nums.length == 0 ) return;

        while( index > 0 && nums[index - 1] >= nums[index] ){
            index--;
        }

        index--;

        if( index == -1 ){
            reverse( nums , 0 , nums.length - 1 );
            return;
        }

        int nextGreaterIndex = nums.length - 1;

        while( nextGreaterIndex >= index && nums[nextGreaterIndex] <= nums[index] ){
            nextGreaterIndex--;
        }

        swap( nums , index , nextGreaterIndex );
        reverse( nums , index + 1 , nums.length - 1 );

    }
}