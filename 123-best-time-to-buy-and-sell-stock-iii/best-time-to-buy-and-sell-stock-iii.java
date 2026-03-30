class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] next = new int[2][3];
        int[][] curr = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int trans = 1; trans >= 0; trans--) {

                    int profit = 0;

                    if (buy == 1) {
                        int take = -prices[i] + next[0][trans];
                        int skip = next[1][trans];
                        profit = Math.max(take, skip);
                    } else {
                        int take = prices[i] + next[1][trans + 1];
                        int skip = next[0][trans];
                        profit = Math.max(take, skip);
                    }

                    curr[buy][trans] = profit;
                }
            }
            int[][] temp = next;
            next = curr;
            curr = temp;
        }

        return next[1][0];
    }
}