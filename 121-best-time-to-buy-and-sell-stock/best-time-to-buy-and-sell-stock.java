class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int ans = 0;

        for( int i = 1 ; i < prices.length ; i++ ){
            ans = Math.max( ans , prices[i] - minPrice );
            minPrice = Math.min( minPrice , prices[i] );
        }

        return ans;
    }
}