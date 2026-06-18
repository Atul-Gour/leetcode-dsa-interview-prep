class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0;
        int twoIndex = n-1;

        int index = 0;

        while( index <= twoIndex ){
            if( nums[index] == 1 ){ index++; continue; }
            else if( nums[index] == 0 ){
                if( index == zeroIndex ){ zeroIndex++; index++; continue; }
                nums[index] = nums[zeroIndex];
                nums[zeroIndex] = 0;
                zeroIndex++;
            }else{
                nums[index] = nums[twoIndex];
                nums[twoIndex] = 2;
                twoIndex--;
            }
        }
    }
}