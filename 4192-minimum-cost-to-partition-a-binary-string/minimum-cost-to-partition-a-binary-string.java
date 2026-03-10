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

        // numSegments[k] = how many segments at level k
        // segLen[k]      = length of each segment at level k
        // level 0 = whole string (1 segment of length n)
        // level m = smallest segments (2^m segments of length n/2^m)

        long[][] dp = new long[m + 1][];

        // bottom level: fill smallest segments first (they can't split, odd length)
        int baseLen = tmp; // = n / 2^m, this is odd
        int baseCount = (int) Math.pow(2, m); // = 2^m segments at bottom
        dp[m] = new long[baseCount];
        for (int i = 0; i < baseCount; i++) {
            int start = i * baseLen;
            int x = pre[start + baseLen] - pre[start];
            dp[m][i] = (x == 0) ? flatCost : (long) baseLen * x * encCost;
        }

        // build up level by level toward the full string
        for (int k = m - 1; k >= 0; k--) {
            int numSegments = (int) Math.pow(2, k);
            int segLen = n / numSegments;
            dp[k] = new long[numSegments];
            for (int i = 0; i < numSegments; i++) {
                int start = i * segLen;
                int x = pre[start + segLen] - pre[start];
                long wholeCost = (x == 0) ? flatCost : (long) segLen * x * encCost;
                // split into left child (2*i) and right child (2*i+1) from level below
                long splitCost = dp[k + 1][2 * i] + dp[k + 1][2 * i + 1];
                dp[k][i] = Math.min(wholeCost, splitCost);
            }
        }

        return dp[0][0];
    }
}