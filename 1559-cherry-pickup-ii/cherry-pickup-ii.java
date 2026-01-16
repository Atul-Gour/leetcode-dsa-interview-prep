class Solution {

    private int add(int i , int j1 , int j2 , int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        if(i > n - 1 || j1 < 0 || j2 < 0 || j1 > m-1 || j2 > m-1 ) return -1;

        if( j1 == j2)return grid[i][j1];
        
        return grid[i][j1] + grid[i][j2];
    }
    
    private int solve(int i , int j1 , int j2 , int[][][] dp , int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        if( i == n )return 0;
        if(dp[i][j1][j2] != -1)return dp[i][j1][j2];

        for(int x = -1 ; x <= 1 ; x++){
            for(int y = -1 ; y <= 1 ; y++){
                
                int sum = add(i + 1, j1 + x , j2 + y , grid);
                
                if(sum == -1)continue;

                ans = Math.max(ans , sum + solve(i + 1, j1 + x , j2 + y , dp , grid) );
            }
        }
        return dp[i][j1][j2] = ans;

    }


    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for(int[][] arr : dp){
            for(int[] a : arr){
                Arrays.fill(a , -1);
            }
        }

        return solve(0 , 0 , m-1 , dp , grid) + grid[0][0] + grid[0][m-1];
    }
}