class Solution {
    private int solve( int index , int curr , int target , int nums[] , int[][] dp ){

        int n = nums.length;

        if ( index == n ){
            if( curr == target ) return 1;
            else return 0;
        }

        int key = curr + (n * 1000);

        if( dp[index][key] != -1 ) return dp[index][key];

        int total = 0;

        total += solve( index + 1 , curr + nums[index] , target , nums , dp );
        total += solve( index + 1 , curr - nums[index] , target , nums , dp );

        return dp[index][key] = total; 

    }

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int MAX = n * 1000 * 2;
        int[][] dp = new int[n][MAX + 1];

        for( int[] arr : dp )Arrays.fill( arr , -1 );

        return solve( 0 , 0 , target , nums , dp );

    }
}