class Solution {
    private int[] solve( int index, int nums[], int[][] dp ){
        int n = nums.length;
        if( index >= n ) return new int[]{0 , 0};

        if(dp[index][0] != -1) return dp[index];

        int maxIncreasingSubsequence = 1;
        int maxIncreasingSubsequenceFreq = 1;

        for( int i = index + 1 ; i < n ; i++ ){
            if( nums[i] <= nums[index] ) continue;

            int[] next = solve( i , nums , dp );
            int currLength = 1 + next[0];

            if( currLength == maxIncreasingSubsequence ) maxIncreasingSubsequenceFreq += next[1];
            else if( currLength > maxIncreasingSubsequence ){
                maxIncreasingSubsequence = currLength;
                maxIncreasingSubsequenceFreq = next[1];
            }
        }

        dp[index][1] = maxIncreasingSubsequenceFreq;
        dp[index][0] = maxIncreasingSubsequence;

        return dp[index];

    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for( int[] arr : dp ) Arrays.fill( arr , -1 );

        for( int i = 0 ; i < n ; i++ ){
            if( dp[i][0] == -1 ){
                solve( i , nums , dp );
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            solve(i, nums, dp);
        }

        int maxLen = 0, total = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                total = dp[i][1];
            } else if (dp[i][0] == maxLen) {
                total += dp[i][1];
            }
        }

        return total;

    }
}