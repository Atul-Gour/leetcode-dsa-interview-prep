class Solution {
    long calculateUniquePaths(int m, int n, int i, int j, long[][] dp) {
        if (i == m - 1 || j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        
        dp[i][j] = calculateUniquePaths(m, n, i + 1, j, dp) 
                 + calculateUniquePaths(m, n, i, j + 1, dp);
        return dp[i][j];
    }
    
    public int uniquePaths(int m, int n) {
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) 
            Arrays.fill(dp[i], -1);
        
        return (int) calculateUniquePaths(m, n, 0, 0, dp);
    }
}
