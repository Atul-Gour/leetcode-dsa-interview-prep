class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int dp[][] = new int[n][n];
        int[][] dirs = {{0 , -1} , {-1 , 0} , {0 , 1} , {1 , 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[2] , b[2]));

        for( int[] d : dp ) Arrays.fill( d , Integer.MAX_VALUE );

        dp[0][0] = grid[0][0];
        pq.offer( new int[]{0 , 0 , dp[0][0]} );

        while( !pq.isEmpty() ){
            int curr[] = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int currTime = curr[2];

            if( i == n-1 && j == n-1 ) return currTime;

            for( int d[] : dirs ){
                int newI = i + d[0];
                int newJ = j + d[1];

                if( newI < 0 || newJ < 0 || newI >= n || newJ >= n ) continue;
                int newTime = Math.max( currTime , grid[newI][newJ] );

                if( dp[newI][newJ] <= newTime ) continue;
                dp[newI][newJ] = newTime;

                pq.offer( new int[]{ newI , newJ , dp[newI][newJ] } );

            }
        }

        return grid[n-1][n-1];

    }
}