class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare( a[2] , b[2] ) );
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};

        for( int[] vis : visited ) Arrays.fill( vis , Integer.MAX_VALUE );
        pq.offer( new int[]{0,0 , grid[0][0] } );
        visited[0][0] = grid[0][0];

        while( !pq.isEmpty() ){
            int curr[] = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int currMax = curr[2];

            if( x == n - 1 && y == n-1 ) return currMax;
            if( visited[x][y] < currMax  ) continue;

            for( int dir[] : dirs ){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if( newX < 0 || newX >= n || newY < 0 || newY >= n ) continue;

                int newMax = Math.max( currMax , grid[newX][newY] );

                if( visited[newX][newY] > newMax ){
                    visited[newX][newY] = newMax;
                    pq.offer( new int[]{ newX , newY , newMax } );
                }
            }
        }

        return -1;
    }
}