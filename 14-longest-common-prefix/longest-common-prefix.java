class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);

            if (prefix.length() == 0) return "";
        }

        return prefix;
    }

    private String commonPrefix(String a, String b) {
        int min = Math.min(a.length(), b.length());
        int i = 0;

        while (i < min && a.charAt(i) == b.charAt(i)) {
            i++;
        }

        return a.substring(0, i);
    }
}