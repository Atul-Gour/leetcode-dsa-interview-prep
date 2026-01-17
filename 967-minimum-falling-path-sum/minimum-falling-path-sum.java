class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int dp[][] = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 0 ; i < n - 1 ; i++){

            Arrays.fill(dp[i + 1] , Integer.MAX_VALUE);
            for(int j = 0 ; j < n ; j++){

                if(j-1 >= 0)
                    dp[i+1][j-1] = Math.min ( dp[i+1][j-1] , dp[i][j] + matrix[i+1][j-1]);
                    
                dp[i+1][j] = Math.min ( dp[i+1][j] , dp[i][j] + matrix[i+1][j]);

                if(j+1 < n)
                    dp[i+1][j+1] = Math.min ( dp[i+1][j+1] , dp[i][j] + matrix[i+1][j+1]);
                
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int ele : dp[n - 1]){
            ans = Math.min(ans , ele);
        }
        return ans;
    }
}