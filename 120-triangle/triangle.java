class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp , Integer.MAX_VALUE);
        Arrays.fill(dp2 , Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        for( int i = 1 ; i < n ; i++ ){
            for( int j = 0 ; j <= i ; j++ ){
                if( j == 0 )dp2[j] = dp[j] + triangle.get(i).get(j);
                else dp2[j] = Math.min( dp[j-1] , dp[j] ) + triangle.get(i).get(j);
            }

            int[] temp = dp;
            dp = dp2;
            dp2 = temp;
        }

        int ans = Integer.MAX_VALUE;
        for( int i = 0 ; i < n ; i++ ){
            ans = Math.min( ans , dp[i] );
        }

        return ans;

    }
}