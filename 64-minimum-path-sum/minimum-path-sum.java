class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] dp = new long[m];
        
        for(int i = n-1; i >= 0; i--){
            dp[m-1] += grid[i][m-1];
            for(int j = m-1; j >= 0; j--){
                if(j + 1 < m){
                    if( i + 1 < n )dp[j] = Math.min(dp[j] , dp[j+1]) + grid[i][j];
                    else dp[j] = dp[j+1] + grid[i][j];
                }
            }
        }

        return (int) dp[0];
    }
}