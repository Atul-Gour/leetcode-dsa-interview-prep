class Solution {

    public List<List<String>> partition(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {

                if (s.charAt(start) == s.charAt(end)) {

                    if (end - start <= 2 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                    }
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        backtrack(0, s, dp, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int index, String s, boolean[][] dp,
                   List<String> curr, List<List<String>> ans) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (dp[index][i]) {
                curr.add(s.substring(index, i + 1));
                backtrack(i + 1, s, dp, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
