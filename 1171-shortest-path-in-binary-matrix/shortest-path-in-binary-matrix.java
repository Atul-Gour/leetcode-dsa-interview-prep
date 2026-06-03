class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        ArrayDeque<int[]> q = new ArrayDeque<>();

        if( grid[0][0] == 1 || grid[n-1][m-1] == 1 ) return -1;
        if( n == 1 && m == 1 ) return 1;

        int dist = 1;

        q.offer( new int[]{n-1 , m - 1} );
        grid[n-1][m-1] = 1;

        while( !q.isEmpty() ){

            int size = q.size();
            dist++;

            while( size-- > 0 ){
                int curr[] = q.poll();
                int x = curr[0];
                int y = curr[1];

                for( int i = -1 ; i <= 1 ; i++ ){
                    for( int j = -1 ; j <= 1 ; j++ ){
                        if( i == 0 && j == 0 ) continue;

                        int newX = x + i;
                        int newY = y + j;

                        if( newX < 0 || newY < 0 || newX >= n || newY >= m || grid[newX][newY] == 1 ) continue;

                        if( newX == 0 && newY == 0 ) return dist;
                        
                        grid[newX][newY] = 1;
                        q.offer( new int[]{newX , newY} );

                    }
                }
            }
        }

        return -1;
    }
}