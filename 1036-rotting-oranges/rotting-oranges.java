class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dirs = new int[][]{ {0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0} };

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( grid[i][j] == 1 ) fresh++;
                else if( grid[i][j] == 2 ) q.offer( new int[]{i , j} ); 
            }
        }

        int time = 0;

        while( !q.isEmpty() ){
            int size = q.size();
            if( fresh == 0 ) return time;
            
            while( size-- > 0 ){
                int curr[] = q.poll();
                int i = curr[0];
                int j = curr[1];

                for( int[] dir : dirs ){
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    if( newI >= n || newI < 0 || newJ >= m || newJ < 0 || grid[newI][newJ] != 1 ) continue;

                    grid[newI][newJ] = 2;
                    fresh--;

                    q.offer( new int[]{ newI , newJ } );
                }

            }

            time++;
        }
    
        return ( fresh > 0 ) ? -1 : time;
        
    }
}