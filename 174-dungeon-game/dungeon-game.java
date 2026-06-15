class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dirs = { {-1 , 0} , {0 , -1} };

        int[][] dp = new int[n][m];
        for( int[] d : dp ) Arrays.fill( d , Integer.MAX_VALUE );

        PriorityQueue<int[]> q = new PriorityQueue<>( (a , b) -> Integer.compare( a[2] , b[2] ) );

        q.offer( new int[]{ n-1 , m-1 , Math.max( 1 , 1 - dungeon[n-1][m-1] ) } );
        dp[n-1][m-1] = Math.max( 1 , 1 - dungeon[n-1][m-1] );

        while( !q.isEmpty() ){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int currNeed = curr[2];

            if( currNeed > dp[x][y] ) continue;

            for( int dir[] : dirs ){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if( newX < 0 || newY < 0 ) continue;

                int newNeed = Math.max( 1 , currNeed - dungeon[newX][newY]);

                if( dp[newX][newY] <= newNeed )continue;

                dp[newX][newY] = newNeed;
                q.offer( new int[]{ newX , newY , newNeed } );
            }
        }

        return dp[0][0];
    }
}