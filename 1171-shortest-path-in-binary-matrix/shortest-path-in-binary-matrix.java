class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        int[][] dist = new int[n][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for( int[] d : dist ) Arrays.fill(d , Integer.MAX_VALUE);

        if( grid[0][0] != 0 ) return -1;

        dist[0][0] = 1;
        q.offer( new int[]{0 , 0} );

        while( !q.isEmpty() ){

            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];

            for( int x = -1 ; x <= 1 ; x++ ){
                for( int y = -1 ; y <= 1 ; y++ ){

                    int newI = i + x;
                    int newJ = j + y;
                    
                    if( newI < 0 || newI >= n || newJ < 0 || newJ >= n || grid[newI][newJ] != 0 ) continue;

                    if( dist[newI][newJ] > dist[i][j] + 1 ){
                        dist[newI][newJ] = dist[i][j] + 1;
                        q.offer( new int[]{ newI , newJ } );
                    }

                }
            }
        }

        return dist[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1][n - 1];
    }
}