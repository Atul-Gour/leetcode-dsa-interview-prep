import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        // Step 1: first and last occurrence
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Step 2: generate minimal valid intervals
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) continue;

            int l = first[c];
            int r = last[c];
            boolean valid = true;

            for (int i = l; i <= r; i++) {
                int ch = s.charAt(i) - 'a';
                if (first[ch] < l) {
                    valid = false;
                    break;
                }
                r = Math.max(r, last[ch]);
            }

            if (valid) intervals.add(new int[]{l, r});
        }

        // Step 3: sort by end
        intervals.sort((a, b) -> a[1] - b[1]);

        // Step 4: greedy selection
        List<String> ans = new ArrayList<>();
        int prevEnd = -1;

        for (int[] in : intervals) {
            if (in[0] > prevEnd) {
                ans.add(s.substring(in[0], in[1] + 1));
                prevEnd = in[1];
            }
        }

        return ans;
    }
}
