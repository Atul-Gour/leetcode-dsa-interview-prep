class Solution {

    public boolean canCross(int[] stones) {
        if( stones[1] != 1 )return false;
        int n = stones.length;

        boolean[][] dp = new boolean[n][n+1];
        Arrays.fill( dp[n-1] , true );

        for( int i = n-1 ; i >= 0 ; i-- ){
            for( int j = 0 ; j <= n ; j++ ){
                if( !dp[i][j]  )continue;

                int prev = stones[i] - j;

                for( int k = i -1 ; k >= 0 ; k-- ){
                    if( stones[k] == prev ){
                        if( j - 1 >= 0 ) dp[k][j - 1] = true;
                        dp[k][j] = true;
                        if( j + 1 <= n ) dp[k][j + 1] = true;
                    }
                    if( stones[k] < prev ) break;
                }
            }
        }
        
        return dp[1][1];
    }
}