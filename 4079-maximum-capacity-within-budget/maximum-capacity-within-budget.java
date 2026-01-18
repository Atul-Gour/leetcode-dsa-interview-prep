import java.util.Arrays;

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = ((long) costs[i] << 32) | capacity[i];
        Arrays.sort(a);

        int[] p = new int[n];
        int mx = 0;
        for (int i = 0; i < n; i++) p[i] = mx = Math.max(mx, (int) a[i]);

        int ans = 0, j = n - 1;
        for (int i = 0; i < n; i++) {
            int c = (int) (a[i] >>> 32);
            int v = (int) a[i];
            if (c < budget) ans = Math.max(ans, v);
            while (j >= 0 && (int) (a[j] >>> 32) >= budget - c) j--;
            int k = Math.min(i - 1, j);
            if (k >= 0) ans = Math.max(ans, v + p[k]);
        }
        return ans;
    }
}