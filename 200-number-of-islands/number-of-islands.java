class Solution {

    private void dfs( int i , int j , boolean[][] visited , char[][] grid ){

        int n = grid.length;
        int m = grid[0].length;

        visited[i][j] = true;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int[] dir : dirs) {

            int newI = i + dir[0];
            int newJ = j + dir[1];

            if (newI < 0 || newI > n - 1 || newJ < 0 || newJ > m - 1 || grid[newI][newJ] == '0' || visited[newI][newJ] ) continue;

            dfs(newI, newJ, visited , grid );
        }
        
    }

    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int ans = 0;

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( !visited[i][j] && grid[i][j] == '1' ){
                    dfs( i , j , visited , grid );
                    ans++;
                }
            }
        }

        return ans;
    }
}