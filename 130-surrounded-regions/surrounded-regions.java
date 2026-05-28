class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dirs = {{0,1} ,{1,0} , {0,-1}, {-1,0}};

        for( int i = 0 ; i < n ; i++ ){
            if( board[i][0] == 'O' ) q.offer( new int[]{ i , 0 } );
            if( board[i][m - 1] == 'O' ) q.offer( new int[]{ i , m - 1 } );
        }

        for( int j = 0 ; j < m ; j++ ){
            if( board[0][j] == 'O' ) q.offer( new int[]{ 0 , j } );
            if( board[n - 1][j] == 'O' ) q.offer( new int[]{ n - 1 , j } );
        }

        while( !q.isEmpty() ){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            if( board[x][y] == 'Y' || board[x][y] == 'X' ) continue;

            board[x][y] = 'Y';

            for( int[] d : dirs ){
                int newX = x + d[0];
                int newY = y + d[1];

                if( newX < 0 || newX >= n || newY < 0 || newY >= m || board[newX][newY] == 'X' || board[newX][newY] == 'Y' ) continue;
                q.offer( new int[]{ newX , newY } );
            }
        }

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( board[i][j] == 'Y' ) board[i][j] = 'O';
                else if( board[i][j] == 'O' ) board[i][j] = 'X';
            }
        }
    }
}