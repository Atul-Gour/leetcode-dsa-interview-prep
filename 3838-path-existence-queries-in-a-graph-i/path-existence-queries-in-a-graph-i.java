class Solution {

    private boolean find(int[] query, int[] nums, int maxDiff, int[] dp) {
        int a = query[0], b = query[1];

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        return dp[b] <= a;
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int queriesLength = queries.length;
        boolean[] ans = new boolean[queriesLength];
        int[] dp = new int[n];

        for( int i = 1 ; i < n ; i++ ){
            dp[i] = i;
            if( Math.abs( nums[i] - nums[i-1] ) <= maxDiff ) dp[i] = dp[i-1];
        }

        for( int i = 0 ; i < queriesLength ; i++ ){
            ans[i] = find( queries[i] , nums , maxDiff , dp );
        }

        return ans;
    }
}
























