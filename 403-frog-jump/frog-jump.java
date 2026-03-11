class Solution {
    public boolean canCross(int[] stones) {

        int n = stones.length;

        boolean[][] dp = new boolean[n][n + 1];

        dp[0][0] = true;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                int jump = stones[i] - stones[j];

                if (jump > n) continue;

                if (dp[j][jump] || 
                   (jump - 1 >= 0 && dp[j][jump - 1]) || 
                   (jump + 1 <= n && dp[j][jump + 1])) {

                    dp[i][jump] = true;

                    if (i == n - 1) return true;
                }
            }
        }

        return false;
    }
}