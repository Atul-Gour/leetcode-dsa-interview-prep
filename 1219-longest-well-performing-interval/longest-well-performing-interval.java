class Solution {
    public int longestWPI(int[] hours) {
        int l = 0;
        int r = 0;
        int n = hours.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + ( hours[i] > 8 ? 1 : -1 );
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || prefix[i] < prefix[stack.peek()]) {
                stack.push(i);
            }
        }

        int maxLen = 0;

        for (int j = n; j >= 0; j--) {
            while (!stack.isEmpty() && prefix[j] > prefix[stack.peek()]) {
                maxLen = Math.max(maxLen, j - stack.pop());
            }
        }

        return maxLen;
    }
}
