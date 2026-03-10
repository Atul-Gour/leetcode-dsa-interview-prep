class Solution {
    private int[] pre;
    private int encCost, flatCost, n;
    private Map<Long, Long> memo = new HashMap<>();

    public long minCost(String s, int encCost, int flatCost) {
        this.n = s.length();
        this.encCost = encCost;
        this.flatCost = flatCost;
        this.pre = new int[n + 1];
        
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + (s.charAt(i) == '1' ? 1 : 0);

        return solve(0, n);
    }

    private long solve(int i, int len) {
        long key = (long) i * 100001 + len;
        if (memo.containsKey(key)) return memo.get(key);

        int ones = pre[i + len] - pre[i];
        long wholeCost = (ones == 0) ? flatCost : (long) len * ones * encCost;

        long best = wholeCost;
        
        if (len % 2 == 0) {
            int half = len / 2;
            long splitCost = solve(i, half) + solve(i + half, half);
            best = Math.min(best, splitCost);
        }

        memo.put(key, best);
        return best;
    }
}