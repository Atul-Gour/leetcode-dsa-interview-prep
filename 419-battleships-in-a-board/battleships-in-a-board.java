class Solution {
    boolean visited[][] ;

    void spread( char[][] board , int i , int j ){

        int n = board.length;
        int m = board[0].length;

        if( (i - 1 >= 0 && board[i-1][j] == 'X' && !visited[i-1][j]) || (i + 1 < n && board[i+1][j] == 'X' && !visited[i+1][j]) ){
            int upwardI = i - 1;

            while( upwardI >= 0 && board[upwardI][j] == 'X' && !visited[upwardI][j] ){
                visited[upwardI][j] = true; upwardI--;
            }

            while( i < n && board[i][j] == 'X' && !visited[i][j] ){
                visited[i][j] = true; i++;
            }
        }else{
            int right = j + 1;

            while( j >= 0 && board[i][j] == 'X' && !visited[i][j] ){
                visited[i][j] = true; j--;
            }

            while( right < m && board[i][right] == 'X' && !visited[i][right] ){
                visited[i][right] = true; right++;
            }
        }
    }

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        int ans = 0;

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( board[i][j] == 'X' && !visited[i][j] ){
                    spread( board , i , j );
                    ans++;
                }
                
            }
        }
        
        return ans;
    }
}