class Solution {

    int[][] dp;

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for(int i = 0; i < n; i++)
            arr[i + 1] = nums[i];

        dp = new int[n + 2][n + 2];

        for( int i = 1 ; i < n + 1 ; i++ ){
            dp[i][i] = arr[i-1] * arr[i] * arr[i+1];
        }

        for( int len = 1 ; len < n ; len++  ){
            for( int i = 1 ; i + len < n + 1 ; i++ ){
                int j = i + len;
                int max = Integer.MIN_VALUE;

                for( int k = i ; k <= j ; k++ ){
                    max = Math.max( max , dp[i][k-1] + ( arr[i-1] * arr[k] * arr[j+1] ) + dp[k+1][j] );
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

}