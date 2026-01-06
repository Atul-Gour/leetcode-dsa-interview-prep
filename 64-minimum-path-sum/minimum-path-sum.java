class Solution {
    int solve(int[][] grid , int[][] visited , int i , int j ){

        if( visited[i][j] != -1) return visited[i][j];

        int n = grid.length;
        int m = grid[0].length;

        if(i == n-1 && j == m-1)return grid[i][j];

        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if(i < n-1 ) left = grid[i][j] + solve( grid , visited , i+1 , j);
        if(j < m-1 ) right = grid[i][j] + solve( grid , visited , i , j+1);

        return visited[i][j] = Math.min( left , right );

    }
    public int minPathSum(int[][] grid) {

        int[][] visited = new int[ grid.length ][ grid[0].length ];

        for(int[] arr : visited){
            Arrays.fill( arr , -1);
        }
        
        return solve( grid , visited , 0 , 0 );
    }
}