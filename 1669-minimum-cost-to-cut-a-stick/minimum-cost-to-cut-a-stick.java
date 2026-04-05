class Solution {

    private int solve(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {

            int cost = (arr[j + 1] - arr[i - 1])
                    + solve(i, k - 1, arr, dp)
                    + solve(k + 1, j, arr, dp);

            ans = Math.min(ans, cost);
        }

        return dp[i][j] = ans;
    }

    public int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);

        int arr[] = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;

        for (int i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }

        int nn = arr.length;
        int dp[][] = new int[nn][nn];

        for (int[] d : dp) Arrays.fill(d, -1);

        return solve(1, nn - 2, arr, dp);
    }
}