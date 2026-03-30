class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for( int i = n-1 ; i >= 0 ; i-- ){
            for( int j = 1 ; j >= 0 ; j--){
                for( int buy = 0 ; buy < 2 ; buy++ ){
                    
                    int profit = 0;

                    if (buy == 1) {
                        int take = -prices[i] + dp[i + 1][1 - buy][j];
                        int skip = dp[i + 1][buy][j];
                        profit = Math.max(take, skip);
                    } else {
                        int take = prices[i] + dp[i + 1][1 - buy][j+1];
                        int skip = dp[i + 1][buy][j];
                        profit = Math.max(take, skip);
                    }

                    dp[i][buy][j] = profit;

                }
            }
        }

        return dp[0][1][0];
    }
}