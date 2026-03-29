class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (str1.charAt(i) == str2.charAt(j)) {
                result.append(str1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] > dp[i][j + 1]) {
                result.append(str1.charAt(i));
                i++;
            } else {
                result.append(str2.charAt(j));
                j++;
            }
        }

        while (i < n) result.append(str1.charAt(i++));
        while (j < m) result.append(str2.charAt(j++));

        return result.toString();
    }
}