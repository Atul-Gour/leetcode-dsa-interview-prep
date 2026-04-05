class Solution {

    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);

        int arr[] = new int[cuts.length + 2];
        int nn = arr.length;

        arr[0] = 0;
        arr[nn - 1] = n;

        for (int i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }

        int dp[][] = new int[nn][nn];

        for (int len = 1; len <= nn - 2; len++) {

            for (int i = 1; i + len - 1 <= nn - 2; i++) {

                int j = i + len - 1;
                int ans = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {

                    int cost = dp[i][k - 1] +
                               dp[k + 1][j] +
                               arr[j + 1] - arr[i - 1];

                    ans = Math.min(ans, cost);
                }

                dp[i][j] = ans == Integer.MAX_VALUE ? 0 : ans;
            }
        }

        return dp[1][nn - 2];
    }
}