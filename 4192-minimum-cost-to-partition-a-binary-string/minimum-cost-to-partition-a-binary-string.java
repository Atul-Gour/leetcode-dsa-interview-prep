class Solution {
    int encCost;
    int flatCost;
    int[] pre;
    Map<Long, Long> memo = new HashMap<>();

    public long minCost(String s, int encCost, int flatCost) {
        pre = new int[s.length() + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + (s.charAt(i - 1) - '0');
        }
        this.encCost = encCost;
        this.flatCost = flatCost;
        return helper(0, s.length());
    }

    private long helper(int l, int r) {
        long key = (long) l * 100001 + r;
        Long cached = memo.get(key);
        if (cached != null) return cached;

        int L = r - l;
        int X = pre[r] - pre[l];
        long cost = (X == 0) ? flatCost : (long) L * X * encCost;

        if (L % 2 == 0) {
            int mid = l + (r - l) / 2;
            cost = Math.min(cost, helper(l, mid) + helper(mid, r));
        }

        memo.put(key, cost);
        return cost;
    }
}