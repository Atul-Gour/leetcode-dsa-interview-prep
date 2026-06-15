class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dirs = { {-1 , 0} , {0 , -1} };

        int[][] dp = new int[n + 1][m + 1];
        for( int[] d : dp ) Arrays.fill( d , Integer.MAX_VALUE );

        dp[n-1][m-1] = Math.max( 1 , 1 - dungeon[n-1][m-1] );

        for( int x = n-1 ; x >= 0 ; x-- ){
            for( int y = m-1 ; y >= 0 ; y-- ){
                
                if( x == n-1 && y == m-1 ) continue;

                dp[x][y] = Math.max( Math.min( dp[x+1][y] , dp[x][y+1] ) - dungeon[x][y] , 1 );

            }
        }

        return dp[0][0];
    }
}