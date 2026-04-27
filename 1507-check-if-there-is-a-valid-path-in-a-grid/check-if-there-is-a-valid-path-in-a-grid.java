class Solution {

    private void left( int i , int j , boolean[][] visited , ArrayDeque<int[]> q , int[][] grid ){
        int n = grid.length;
        int m = grid[0].length;

        if( j - 1 >= 0 && !visited[i][j - 1] && ( grid[i][j-1] == 4 || grid[i][j-1] == 6 ) ){
            visited[i][j - 1] = true;
            q.offer( new int[]{ i , j-1 } );
        }
    }

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer( new int[]{ 0 , 0 } );
        visited[0][0] = true;

        while( !q.isEmpty() ){
            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];


            if( i == n-1 && j == m-1 ){return true;}
            int street = grid[i][j];

            if( street == 1 ){
                if( j - 1 >= 0 && !visited[i][j - 1] && ( grid[i][j-1] == 1 || grid[i][j-1] == 4 || grid[i][j-1] == 6 ) ){ visited[i][j - 1] = true;  q.offer( new int[]{ i , j-1 } );} // left
                if( j + 1 < m && !visited[i][j + 1] && ( grid[i][j+1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5 ) ){ visited[i][j + 1] = true; q.offer( new int[]{ i , j+1 } ); }// right
            }
            else if( street == 2 ){
                if( i - 1 >= 0 && !visited[i-1][j] && ( grid[i-1][j] == 2 || grid[i-1][j] == 3 || grid[i-1][j] == 4 ) ){ visited[i-1][j] = true;  q.offer( new int[]{ i-1 , j } );} // up
                if( i + 1 < n && !visited[i+1][j] && ( grid[i+1][j] == 2 || grid[i+1][j] == 5 || grid[i+1][j] == 6 ) ){ visited[i+1][j] = true; q.offer( new int[]{ i+1 , j } ); }// down
            }
            else if( street == 3 ){
                if( j - 1 >= 0 && !visited[i][j - 1] && ( grid[i][j-1] == 1 || grid[i][j-1] == 4 || grid[i][j-1] == 6 ) ){ visited[i][j - 1] = true;  q.offer( new int[]{ i , j-1 } );}// left
                if( i + 1 < n && !visited[i+1][j] && ( grid[i+1][j] == 2 || grid[i+1][j] == 5 || grid[i+1][j] == 6 ) ){ visited[i+1][j] = true; q.offer( new int[]{ i+1 , j } ); }// down
            }
            else if( street == 4 ){
                if( j + 1 < m && !visited[i][j + 1] && ( grid[i][j+1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5 ) ){ visited[i][j + 1] = true; q.offer( new int[]{ i , j+1 } ); }// right
                if( i + 1 < n && !visited[i+1][j] && ( grid[i+1][j] == 2 || grid[i+1][j] == 5 || grid[i+1][j] == 6 ) ){ visited[i+1][j] = true; q.offer( new int[]{ i+1 , j } ); }// down
            }
            else if( street == 5 ){
                if( i - 1 >= 0 && !visited[i-1][j] && ( grid[i-1][j] == 2 || grid[i-1][j] == 3 || grid[i-1][j] == 4 ) ){ visited[i-1][j] = true;  q.offer( new int[]{ i-1 , j } );} // up
                if( j - 1 >= 0 && !visited[i][j - 1] && ( grid[i][j-1] == 1 || grid[i][j-1] == 4 || grid[i][j-1] == 6 ) ){ visited[i][j - 1] = true;  q.offer( new int[]{ i , j-1 } );} // left
            }
            else{
                if( i - 1 >= 0 && !visited[i-1][j] && ( grid[i-1][j] == 2 || grid[i-1][j] == 3 || grid[i-1][j] == 4 ) ){ visited[i-1][j] = true;  q.offer( new int[]{ i-1 , j } );} // up
                if( j + 1 < m && !visited[i][j + 1] && ( grid[i][j+1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5 ) ){ visited[i][j + 1] = true; q.offer( new int[]{ i , j+1 } ); }// right
            }
        }

        return false;
    }
}