class Solution {

    long[][][] memo;

    private long solve(int i, int j, int p,
            int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int m = nums2.length;

        if (p == k)
            return 0;

        if (i == n || j == m)
            return Long.MIN_VALUE / 2;

        if (memo[i][j][p] != Long.MIN_VALUE)
            return memo[i][j][p];

        long skip1 = solve(i + 1, j, p, nums1, nums2, k);
        long skip2 = solve(i, j + 1, p, nums1, nums2, k);

        long take = (long) nums1[i] * nums2[j] +
                solve(i + 1, j + 1, p + 1, nums1, nums2, k);

        return memo[i][j][p] = Math.max(take, Math.max(skip1, skip2));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int m = nums2.length;

        memo = new long[n][m][k + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(memo[i][j], Long.MIN_VALUE);

        return solve(0, 0, 0, nums1, nums2, k);
    }
}