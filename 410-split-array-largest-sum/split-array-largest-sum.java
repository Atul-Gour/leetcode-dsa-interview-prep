import java.util.*;

class Solution {

    public int splitArray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[][] dp = new long[k + 1][n];

        // Base case: 1 partition
        for (int i = 0; i < n; i++) {
            dp[1][i] = prefix[n] - prefix[i];
        }

        // Fill for partitions = 2 to k
        for (int p = 2; p <= k; p++) {

            for (int i = 0; i <= n - p; i++) {

                long ans = Long.MAX_VALUE;

                // Try placing first cut
                for (int j = i; j <= n - p; j++) {

                    long firstPart = prefix[j + 1] - prefix[i];
                    long secondPart = dp[p - 1][j + 1];

                    ans = Math.min(ans, Math.max(firstPart, secondPart));
                }

                dp[p][i] = ans;
            }
        }

        return (int) dp[k][0];
    }
}