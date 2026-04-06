class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] grid = new int[n + 1][m];
        
        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = 0 ; j < m ; j++ ){
                if( matrix[i][j] == '0' ) continue;
                grid[i][j] = grid[i+1][j] + (matrix[i][j] == '1' ? 1 : 0);
            }
        }


        int ans = 0;

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){

                int min = Integer.MAX_VALUE;

                for( int k = j ; k >= 0 ; k-- ){
                    min = Math.min( min , grid[i][k] );
                    if( min == 0 ) break;
                    int cost =  min * ( j - k + 1 );
                    ans = Math.max( ans , cost );
                }
            }
        }

        return ans;
    }
}