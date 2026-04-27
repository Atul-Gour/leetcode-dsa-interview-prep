class Solution {
    public void swap(int[] nums ,int i , int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]= temp;
    }
    public int[] rearrangeArray(int[] nums) {
        for(int i = 0 ; i<nums.length-1;i++){
            if(i%2==0){
                if(nums[i]>=0){
                    continue;
                }
                else{
                    int j= i+1;
                    while(j<nums.length&&nums[j]<0){
                        swap(nums,i,j);
                        j++;
                    }
                    swap(nums,i,j);
                }
            }
            else{
                if(nums[i]<0){
                    continue;
                }
                else{
                    int j= i+1;
                    while(j<nums.length&&nums[j]>=0){
                        swap(nums,i,j);
                        j++;
                    }
                    swap(nums,i,j);
                }
            }
        }
        return nums;
    }
}