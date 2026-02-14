import java.util.*;

class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1]; 
        for (int index = n - 1; index >= 0; index--) {

            int max = 0;
            int ans = 0;

            for (int i = index; i < n && i < index + k; i++) {
                max = Math.max(max, arr[i]);
                ans = Math.max(ans, max * (i - index + 1) + dp[i + 1]);
            }

            dp[index] = ans;
        }

        return dp[0];
    }
}