import java.util.*;

class Solution {

    private long solve(int index, int parts, long[] prefix, long[][] dp, int n, int k) {

        if (parts == k) {
            return (index == n) ? 0 : Long.MAX_VALUE;
        }

        if (index == n) {
            return Long.MAX_VALUE;
        }

        if (dp[parts][index] != -1) return dp[parts][index];

        long ans = Long.MAX_VALUE;

        for (int i = index; i < n; i++) {

            long currSum = prefix[i + 1] - prefix[index];

            long future = solve(i + 1, parts + 1, prefix, dp, n, k);

            if (future == Long.MAX_VALUE) continue;

            ans = Math.min(ans, Math.max(currSum, future));
        }

        return dp[parts][index] = ans;
    }

    public int splitArray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[][] dp = new long[k][n];
        for (long[] row : dp)
            Arrays.fill(row, -1);

        return (int) solve(0, 0, prefix, dp, n, k);
    }
}