class Solution {
    boolean isCorrect( int index , int[] nums){
        if(index % 2 == 0){
            return nums[index] == nums[index + 1];
        }
        else return nums[index] == nums[index - 1];
    }
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left < right){

            int mid = left + (right - left)/2;

            if( isCorrect( mid , nums )) left = mid + 1;
            else right = mid;
        }

        return nums[right];
    }
}