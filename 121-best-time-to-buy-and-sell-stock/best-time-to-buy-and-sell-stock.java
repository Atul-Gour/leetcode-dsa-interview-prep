class Solution {
    public int maxProfit(int[] prices) {
        int buyprice = Integer.MAX_VALUE;
        int ans = 0;

        for(int i = 0 ; i < prices.length ; i++ ){

            buyprice = Math.min( buyprice , prices[i] );

            ans = Math.max( ans , prices[i] - buyprice );
        }

        return ans;
    }
}