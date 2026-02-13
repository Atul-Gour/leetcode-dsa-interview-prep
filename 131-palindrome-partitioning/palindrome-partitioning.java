class Solution {

    void solve(int index, String s, List<String> currList, List<List<String>> ans) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(currList));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                currList.add(s.substring(index, i + 1));
                solve(i + 1, s, currList, ans);
                currList.remove(currList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);
        return ans;
    }
}
