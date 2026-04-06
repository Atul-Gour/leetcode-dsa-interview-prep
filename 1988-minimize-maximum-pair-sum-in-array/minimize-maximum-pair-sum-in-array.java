class Solution {
    public int minPairSum(int[] nums) {

        Arrays.sort( nums );
        int max = 0;
        int n = nums.length;
        
        for( int i = 0 ; i < n/2 ; i++ ){
            int j = n - i - 1;
            max = Math.max( max , nums[i] + nums[j] );
        }

        return max;
    }
}