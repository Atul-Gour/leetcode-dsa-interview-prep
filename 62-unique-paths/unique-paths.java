class Solution {
    long solve(int m, int n, int i, int j, long[][] dp) {
        if (i >= m || j >= n) return 0;
        if (i == m-1 && j == n-1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] =
            solve(m,n,i+1,j,dp) +
            solve(m,n,i,j+1,dp);
    }   
    
    public int uniquePaths(int m, int n) {
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) 
            Arrays.fill(dp[i], -1);
        
        return (int) solve(m, n, 0, 0, dp);
    }
}
