class Solution {

    void spread( char[][] board , int i , int j ){

        int n = board.length;
        int m = board[0].length;

        if( (i - 1 >= 0 && board[i-1][j] == 'X' ) || (i + 1 < n && board[i+1][j] == 'X') ){
            int upwardI = i - 1;

            while( upwardI >= 0 && board[upwardI][j] == 'X' ){
                board[upwardI][j] = 'Y'; upwardI--;
            }

            while( i < n && board[i][j] == 'X' ){
                board[i][j] = 'Y'; i++;
            }
        }else{
            int right = j + 1;

            while( j >= 0 && board[i][j] == 'X' ){
                board[i][j] = 'Y'; j--;
            }

            while( right < m && board[i][right] == 'X' ){
                board[i][right] = 'Y'; right++;
            }
        }
    }

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int ans = 0;

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( board[i][j] == 'X' ){
                    spread( board , i , j );
                    ans++;
                }
                
            }
        }
        
        return ans;
    }
}