class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dirs = { {-1 , 0} , {0 , -1} };

        int[][] dp = new int[n][m];
        for( int[] d : dp ) Arrays.fill( d , Integer.MAX_VALUE );

        dp[n-1][m-1] = Math.max( 1 , 1 - dungeon[n-1][m-1] );

        for( int x = n-1 ; x >= 0 ; x-- ){
            for( int y = m-1 ; y >= 0 ; y-- ){
                
                if( x == 0 && y == 0 ) continue;

                for( int dir[] : dirs ){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if( newX < 0 || newY < 0 ) continue;

                    int newNeed = Math.max( 1 , dp[x][y] - dungeon[newX][newY] );

                    if( dp[newX][newY] <= newNeed )continue;

                    dp[newX][newY] = newNeed;
                }
            }
        }

        return dp[0][0];
    }
}