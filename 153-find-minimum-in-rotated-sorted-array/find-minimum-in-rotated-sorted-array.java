class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;

        while( l <= r ){
            int mid = l + (r - l)/2;

            if( nums[l] <= nums[mid] ){
                if( nums[r] <= nums[l] ){
                    ans = nums[r];
                    l = mid + 1;
                }
                else{
                    ans = nums[l];
                    r = mid - 1;
                }
            }
            else{
                ans = nums[mid] ;
                if( mid - 1 >= 0 && nums[mid - 1] <= nums[mid] ) r = mid - 1;
                else break;
            }
        }

        return ans;
    }
}