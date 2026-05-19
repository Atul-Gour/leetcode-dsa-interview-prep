class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int n = nums.length;
        int r = n - 1;

        while( l < r ){
            int mid = l + (r - l)/2;
            if( mid % 2 == 0 ){
                if( mid + 1 < n && nums[mid] == nums[mid + 1] ) l = mid + 2;
                else r = mid;
            }
            else{
                if( mid - 1 >= 0 && nums[mid] == nums[mid - 1] ) l = mid + 1;
                else r = mid;
            }
        }

        return nums[l];
    }
}