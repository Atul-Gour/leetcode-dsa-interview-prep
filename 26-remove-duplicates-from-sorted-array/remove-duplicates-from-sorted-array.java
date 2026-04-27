class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0 , j = 0;
        int n = nums.length;

        while( j < n ){
            while( j + 1 < n && nums[j + 1] == nums[j] ) j++;

            nums[i] = nums[j];

            i++;
            j++;
        }

        return i;
    }
}