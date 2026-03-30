class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int curr[] = new int[2*k + 1];
        int next[] = new int[2*k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int trans = 2*k - 1 ; trans >= 0 ; trans--) {
                int profit = 0;

                    if (trans % 2 == 0) {
                        int take = -prices[i] + next[trans + 1];
                        int skip = next[trans];
                        profit = Math.max(take, skip);
                    } else {
                        int take = prices[i] + next[trans + 1];
                        int skip = next[trans];
                        profit = Math.max(take, skip);
                    }

                    curr[trans] = profit;
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }

        return next[0];
    }
}