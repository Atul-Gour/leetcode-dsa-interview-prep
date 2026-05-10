class Solution {
    private int findRotateIndex( int[] nums ){
        int l = 0;
        int r = nums.length - 1;
        int n = nums.length;

        while( l < r ){
            int mid = l + (r-l)/2;
            if( nums[mid] >= nums[n-1] ) l = mid + 1;
            else r = mid;
        }

        return r;
    }

    public int search(int[] nums, int l ,int r , int target) {

        while( l <= r ){
            int mid = l + (r-l)/2;
            if( nums[mid] == target ) return mid;
            else if( nums[mid] < target ) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if( n == 1 ) return nums[0] == target ? 0 : -1;

        int l2 = findRotateIndex( nums );
        if( target >= nums[l2] && target <= nums[n-1] ) return search(nums, l2 , n-1 , target);

        if( l2 > 0 && target >= nums[0] && target <= nums[l2-1] ) return search(nums, 0 , l2-1 , target);

        return -1;

    }
}