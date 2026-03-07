class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int maxCnt = 0;
        for (char c : tasks) {
            if (++cnt[c - 'A'] > maxCnt) {
                maxCnt = cnt[c - 'A'];
            }
        }
        int tot = 0;
        for (int c : cnt) {
            if (c == maxCnt) {
                tot++;
            }
        }

        return Math.max(tasks.length, (n + 1) * (maxCnt - 1) + tot);
    }
}