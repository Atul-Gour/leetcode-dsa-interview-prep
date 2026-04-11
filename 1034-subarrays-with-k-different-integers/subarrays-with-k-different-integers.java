class Solution {

    private int count( int[] nums, int k ){

        int n = nums.length;
        int[] freq = new int[n + 1];
        int unique = 0;

        int l = 0;
        int total = 0;

        for( int r = 0 ; r < nums.length ; r++ ){

            freq[nums[r]]++;
            if( freq[nums[r]] == 1 ) unique++;  

            while( unique > k ){
                freq[nums[l]]--;
                if( freq[nums[l]] == 0 ) unique-- ;
                l++;
            }

            total += r - l + 1; 

        }

        return total;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count( nums , k ) - count( nums , k - 1 );
    }
}