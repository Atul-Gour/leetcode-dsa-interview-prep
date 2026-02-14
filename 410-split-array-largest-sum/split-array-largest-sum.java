import java.util.*;

class Solution {

    public int splitArray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        dp[k][n] = 0;

        for (int parts = k - 1; parts >= 0; parts--) {

            for (int index = n - (k - parts); index >= 0; index--) {

                long ans = Long.MAX_VALUE;

                for (int i = index; i <= n - (k - parts); i++) {

                    long currSum = prefix[i + 1] - prefix[index];
                    long future = dp[parts + 1][i + 1];


                    ans = Math.min(ans, Math.max(currSum, future));
                }

                dp[parts][index] = ans;
            }
        }

        return (int) dp[0][0];
    }
}