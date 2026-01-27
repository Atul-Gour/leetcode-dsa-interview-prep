class Solution {

    private boolean isLand(int i , int j , char[][] grid , boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        if( i < 0 || j < 0 || i >= n || j >= m) return false;

        return (grid[i][j] == '1' && !visited[i][j]) ;
    }

    private void dfs( int i , int j , boolean[][] visited , char[][] grid ){

        visited[i][j] = true;

        if( isLand( i , j + 1 , grid , visited ) ) dfs( i , j+1 , visited , grid);
        if( isLand( i , j - 1 , grid , visited ) ) dfs( i , j-1 , visited , grid);
        if( isLand( i + 1 , j , grid , visited ) ) dfs( i+1 , j , visited , grid);
        if( isLand( i - 1 , j , grid , visited ) ) dfs( i-1 , j , visited , grid);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int ans = 0;

        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < m ; j++ ){
                if( !visited[i][j] && grid[i][j] == '1' ){
                    ans++;
                    dfs( i , j , visited , grid );
                }
            }
        }

        return ans;
    }
}