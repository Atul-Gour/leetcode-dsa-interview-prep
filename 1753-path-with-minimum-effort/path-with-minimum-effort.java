class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        if( n == 1 && m == 1 ) return 0;

        PriorityQueue< int[] > pq = new PriorityQueue<>( (int[] a , int[] b) -> Integer.compare( a[2] , b[2] ) );
        int[][] dirs = { {0 , 1} , {0 , -1} , {-1 , 0} , {1 , 0} };
        int[][] effort = new int[n][m];

        for( int[] eff : effort ) Arrays.fill( eff , Integer.MAX_VALUE );

        pq.offer( new int[]{0 , 0, 0} );
        effort[0][0] = 0;    

        while( !pq.isEmpty() ){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int currMaxEffort = curr[2];

            if( x == n-1 && y == m-1 ) return currMaxEffort;

            for( int[] dir : dirs ){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if( newX < 0 || newY < 0 || newX >= n || newY >= m ) continue;

                int newMaxEffort = Math.max(currMaxEffort , Math.abs( heights[newX][newY] - heights[x][y] ));

                if( newMaxEffort < effort[newX][newY] ){
                    effort[newX][newY] = newMaxEffort;
                    pq.offer( new int[]{ newX , newY , newMaxEffort } );
                }
                
            }
        }

        return 0;
    }
}