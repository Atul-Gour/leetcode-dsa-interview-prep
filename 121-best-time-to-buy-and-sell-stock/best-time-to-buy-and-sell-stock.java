class Solution {
    public int maxProfit(int[] prices) {

        int minIdx = 0;
        int maxIdx = 0;
        int ans = 0;

        for ( int i = 1 ; i < prices.length ; i++ ){

            if( prices[i] < prices[minIdx] ){
                minIdx = i;
                maxIdx = i;
            }
            if( prices[i] > prices[maxIdx] ){
                maxIdx = i;
                ans = Math.max( ans , prices[maxIdx] - prices[minIdx] );
            }

        }

        return ans;

    }
}