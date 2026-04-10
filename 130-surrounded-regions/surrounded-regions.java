class Solution {

    private void dfs(int i, int j, char[][] board ) {
        int n = board.length;
        int m = board[0].length;

        board[i][j] = '#';

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int[] dir : dirs) {

            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI < 0 || newI > n - 1 || newJ < 0 || newJ > m - 1 || board[newI][newJ] == 'X' || board[newI][newJ] == '#' ) continue;

            dfs(newI, newJ, board ) ;
        }

    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for( int i = 0 ; i < n ; i++ ) if( board[i][0] == 'O' ) dfs( i , 0 , board );
        for( int i = 0 ; i < n ; i++ ) if( board[i][m-1] == 'O' ) dfs( i , m-1 , board );
        for( int j = 0 ; j < m ; j++ ) if( board[0][j] == 'O' ) dfs( 0 , j , board );
        for( int j = 0 ; j < m ; j++ ) if( board[n-1][j] == 'O' ) dfs( n-1 , j , board );

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( board[i][j] == '#' ) board[i][j] = 'O';
                else if( board[i][j] == 'O' ) board[i][j] = 'X';
            }
        }
    }
}