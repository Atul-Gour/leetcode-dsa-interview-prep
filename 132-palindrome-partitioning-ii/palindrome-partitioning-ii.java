class Solution {

    public boolean[][] buildPalindromeTable(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                if (gap == 0) isPal[i][j] = true;
                else if (gap == 1) isPal[i][j] = (s.charAt(i) == s.charAt(j));
                else isPal[i][j] = (s.charAt(i) == s.charAt(j)) && isPal[i+1][j-1];
            }
        }

        return isPal;
    }

    public int minCut(String s) {

        int n = s.length();
        boolean[][] isPal = buildPalindromeTable(s);

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            if (isPal[0][i]) {
                dp[i] = 0;
                continue;
            }

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                if (isPal[j+1][i]) {
                    min = Math.min(min, dp[j] + 1);
                }
            }

            dp[i] = min;
        }

        return dp[n - 1];
    }
}