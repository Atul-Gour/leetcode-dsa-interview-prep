class Solution {

    private int solve(int i, int j, int[][] dungeon, int[][] dp) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        if (i >= n || j >= m) return Integer.MAX_VALUE;

        if (i == n - 1 && j == m - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        // memoization
        if (dp[i][j] != -1) return dp[i][j];

        int right = solve(i, j + 1, dungeon, dp);
        int down = solve(i + 1, j, dungeon, dp);

        int need = Math.min(right, down);

        // health required at current cell
        int ans = Math.max(1, need - dungeon[i][j]);

        return dp[i][j] = ans;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];

        // initialize with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, dungeon, dp);
    }
}