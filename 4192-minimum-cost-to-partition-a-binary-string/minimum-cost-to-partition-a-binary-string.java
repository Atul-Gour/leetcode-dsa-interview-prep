class Solution {
    public long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + (s.charAt(i) == '1' ? 1 : 0);

        // count how many times n is divisible by 2
        int m = 0;
        int tmp = n;
        while (tmp % 2 == 0) { tmp /= 2; m++; }

        long[][] dp = new long[m + 1][];

        // bottom level: smallest segments (length = n >> m, which is odd or 1)
        int baseLen = n >> m;
        dp[m] = new long[1 << m];
        for (int i = 0; i < (1 << m); i++) {
            int start = i * baseLen;
            int x = pre[start + baseLen] - pre[start];
            dp[m][i] = (x == 0) ? flatCost : (long) baseLen * x * encCost;
        }

        // build up from bottom
        for (int k = m - 1; k >= 0; k--) {
            int len = n >> k;
            dp[k] = new long[1 << k];
            for (int i = 0; i < (1 << k); i++) {
                int start = i * len;
                int x = pre[start + len] - pre[start];
                long wholeCost = (x == 0) ? flatCost : (long) len * x * encCost;
                long splitCost = dp[k + 1][2 * i] + dp[k + 1][2 * i + 1];
                dp[k][i] = Math.min(wholeCost, splitCost);
            }
        }

        return dp[0][0];
    }
}