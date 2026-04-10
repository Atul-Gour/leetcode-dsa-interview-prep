class Solution {
    
    private void bfs( int sr , int sc , int[][] grid ){
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs  = { { 0 , 1 } , {1 , 0} , {0 , -1} , {-1 , 0} };
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer( new int[]{sr , sc} );
        grid[sr][sc] = 0;

        while( !q.isEmpty() ){
            
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            for( int[] dir : dirs ){

                int newI = i + dir[0];
                int newJ = j + dir[1];

                if( newI < 0 || newJ < 0 || newI >= n || newJ >= m ) continue;

                if( grid[newI][newJ] == 1 ){
                    grid[newI][newJ] = 0;
                    q.offer( new int[]{ newI , newJ } );
                }
                    
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        for( int i = 0 ; i < n ; i++ ) if( grid[i][0] == 1 ) bfs( i , 0 , grid );
        for( int i = 0 ; i < n ; i++ ) if( grid[i][m-1] == 1 ) bfs( i , m-1 , grid );
        for( int j = 0 ; j < m ; j++ ) if( grid[0][j] == 1 ) bfs( 0 , j , grid );
        for( int j = 0 ; j < m ; j++ ) if( grid[n-1][j] == 1 ) bfs( n-1 , j , grid );

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( grid[i][j] == 1 ){
                    ans++;
                }
            }
        }

        return ans;

    }
}