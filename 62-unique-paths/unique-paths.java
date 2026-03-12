class Solution {
    public int uniquePaths(int m, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        dp[0][0] = 1;
        q.offer(new int[]{0 , 0});

        while( !q.isEmpty() ){
            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];
            if( visited[i][j] )continue;
            visited[i][j] = true;

            if( i + 1  < m ){
                dp[i+1][j] += dp[i][j];
                q.offer(new int[]{i+1 , j});
            }

            if( j + 1  < n ){
                dp[i][j+1] += dp[i][j];
                q.offer(new int[]{i , j+1});
            }
        }

        // for( int[] arr : dp ){
        //     for( int ele : arr ){
        //         System.out.print( ele + " " );
        //     }
        //     System.out.println();
        // }

        return dp[m-1][n-1];
    }
}