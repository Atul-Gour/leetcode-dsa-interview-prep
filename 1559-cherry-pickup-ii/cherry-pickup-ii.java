class Solution {
    private int find( int i , int j1 , int j2 , int[][] grid , int[][][] dp ){
        int n = grid.length;
        int m = grid[0].length;
        if( i >= n )return 0;
        if( dp[i][j1][j2] != -1 )return dp[i][j1][j2];

        int max = 0;
        int dirs[] = {-1 , 0 , 1};
        
        for( int dir : dirs ){
            int jj1 = j1 + dir;
            for( int dir2 : dirs ){
                int jj2 = j2 + dir2;

                if( jj1 < 0 || jj1 >= m || jj2 < 0 || jj2 >= m )continue;
                max = Math.max( max , find( i + 1 , jj1 , jj2 , grid , dp ) );
            }
        }

        int cherries = grid[i][j1];
        if(j1 != j2) cherries += grid[i][j2];
        

        return dp[i][j1][j2] = cherries + max;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for( int[][] arr : dp ){
            for( int[] a : arr ){
                Arrays.fill( a , -1 );
            }
        }

        return find( 0 , 0 , m-1 , grid , dp );
    }
}