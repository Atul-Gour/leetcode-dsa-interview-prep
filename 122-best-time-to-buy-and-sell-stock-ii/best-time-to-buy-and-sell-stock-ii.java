class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] curr = new int[2];
        int[] prev = new int[2];

        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = 0 ; j <= 1 ; j++ ){

                int profit;

                if (j == 1) {
                    int buy = -prices[i] + prev[0];
                    int skip = prev[1];
                    profit = Math.max(buy, skip);
                } else {
                    int sell = prices[i] + prev[1];
                    int skip = prev[0];
                    profit = Math.max(sell, skip);
                }

                curr[j] = profit;
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[1];
    }
}