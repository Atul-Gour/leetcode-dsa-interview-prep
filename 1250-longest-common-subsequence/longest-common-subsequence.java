class Solution {
    public int longestCommonSubsequence(String a, String b) {

        int n = a.length();
        int m = b.length();

        int[] dp = new int[m + 1];
        int[] curr = new int[m + 1];

        for(int i = n - 1; i >= 0; i--) {

            for(int j = m - 1; j >= 0; j--) {

                if(a.charAt(i) == b.charAt(j))
                    curr[j] = 1 + dp[j + 1];
                else
                    curr[j] = Math.max(curr[j + 1], dp[j]);
            }

            int[] temp = dp;
            dp = curr;
            curr = temp;
        }

        return dp[0];
    }
}