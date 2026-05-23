class Solution {

    private int[] find( int[][] mat , boolean[][] visited , int i , int j ){

        int n = mat.length;
        int m = mat[0].length;

        if( i < 0 || i >= n || j < 0 || j >= m || visited[i][j] ) return new int[]{0 , -1 , -1};

        visited[i][j] = true;
        boolean peak = true;

        if( i > 0 && mat[i-1][j] > mat[i][j] ){
            peak = false;
            int[] curr = find( mat, visited, i - 1 , j );
            if( curr[0] == 1 ) return curr;
        }

        if( i < n-1 && mat[i+1][j] > mat[i][j] ){
            peak = false;
            int[] curr = find( mat, visited, i + 1 , j );
            if( curr[0] == 1 ) return curr;
        }

        if( j > 0 && mat[i][j-1] > mat[i][j] ){
            peak = false;
            int[] curr = find( mat, visited, i , j-1 );
            if( curr[0] == 1 ) return curr;
        }

        if( j < m-1 && mat[i][j+1] > mat[i][j] ){
            peak = false;
            int[] curr = find( mat, visited, i , j+1 );
            if( curr[0] == 1 ) return curr;
        }

        if( peak ) return new int[]{ 1 , i , j };
        else return new int[]{ 0 , -1 , -1 };

    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];

        int[] ans = find( mat , visited , 0 , 0 );

        return new int[]{ ans[1] , ans[2] };
    }
}