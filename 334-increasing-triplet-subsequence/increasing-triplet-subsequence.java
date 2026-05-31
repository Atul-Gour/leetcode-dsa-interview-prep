class Solution {
    public boolean increasingTriplet(int[] nums) {

        int n = nums.length;
        if( n < 3 ) return false;

        int a = -1;
        int b = -1;
        int c = -1;

        for( int i = 0 ; i < n ; i++ ){
            
            int curr = nums[i];

            if( a == -1 || nums[a] > curr ){
                a = i;
                continue;
            }

            if( curr > nums[a] && ( b == -1 || curr < nums[b]) ){
                b = i;
                continue;
            }

            if( b != -1 && curr > nums[b] ){
                c = i;
                return true;
            }
        }

        return false;
    }
}