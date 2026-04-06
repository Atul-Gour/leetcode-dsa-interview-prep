class Solution {
    public int minPairSum(int[] nums) {

        Arrays.sort( nums );
        int max = 0;
        int n = nums.length;
        
        for( int i = 0 , j = n-1 ; i < n/2 && j >= n/2 ; i++ , j-- ){
            max = Math.max( max , nums[i] + nums[j] );
        }

        return max;
    }
}