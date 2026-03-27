class Solution {

    public int perfectSum(int[] nums, int target) {
        
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        if (nums[0] == 0) {
            dp[0][0] = 2;  
        } else {
            dp[0][0] = 1;
            if (nums[0] <= target) dp[0][nums[0]] = 1;
        }
        
        for(  int i = 1 ; i < n ; i++ ){
            for( int sum = 0 ; sum <= target ; sum++ ){
                dp[i][sum] += dp[i-1][sum] ;
                if( nums[i] <= sum ) dp[i][sum] += dp[i-1][sum - nums[i]] ;
            }
        }
        
        return dp[n-1][target] ;
    }
    
    public int countPartitions(int[] arr, int diff) {
        long total = 0;
        for( int ele : arr ) total += ele;
        if (Math.abs(diff) > total) return 0;
        int target = (int)( total + diff );
        
        if( target % 2 != 0 )return 0;
        
        
        return perfectSum(arr , target/2 );
    }

    public int findTargetSumWays(int[] nums, int target) {

        return countPartitions( nums , target );
    }
}