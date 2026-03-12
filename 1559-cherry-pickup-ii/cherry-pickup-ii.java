class Solution {
    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){

                if(j1 == j2)
                    dp[n-1][j1][j2] = grid[n-1][j1];
                else
                    dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        int[] dirs = {-1,0,1};

        for(int i = n-2; i >= 0; i--){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){

                    int max = 0;

                    for(int d1 : dirs){
                        for(int d2 : dirs){

                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if(nj1 < 0 || nj1 >= m || nj2 < 0 || nj2 >= m)
                                continue;

                            max = Math.max(max, dp[i+1][nj1][nj2]);
                        }
                    }

                    int cherries = grid[i][j1];
                    if(j1 != j2) cherries += grid[i][j2];

                    dp[i][j1][j2] = cherries + max;
                }
            }
        }

        return dp[0][0][m-1];
    }
}