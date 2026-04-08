class Solution {
    private int count( int[] nums ){
        int n = nums.length;
        int squares = 0;

        for( int j = 0; j < n ; j++ ){
            int length = Integer.MAX_VALUE;

            for( int i = j ; i >= 0 ; i-- ){
                length = Math.min( length , nums[i] );
                int width = j - i + 1;
                if( length >= width ) squares++;
                else break;

            }
        }
    

        return squares;
    }

    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] grid = new int[n + 1][m];
        
        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = 0 ; j < m ; j++ ){
                if( matrix[i][j] == 0 ) continue;
                grid[i][j] = grid[i+1][j] + (matrix[i][j] == 1 ? 1 : 0);
            }
        }


        int ans = 0;

        for( int i = 0 ; i < n ; i++ ){
            ans += count( grid[i] );
        }

        return ans;
    }
}