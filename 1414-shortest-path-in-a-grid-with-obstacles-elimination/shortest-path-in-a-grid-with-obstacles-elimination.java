class Solution {
    public int shortestPath(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dist = new int[k+1][n][m];

        for(int[][] ar : dist){
            for(int[] row : ar){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,k,0});

        dist[k][0][0] = 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int[] curr = q.poll();

            int i = curr[0];
            int j = curr[1];
            int rem = curr[2];
            int steps = curr[3];

            if(i == n-1 && j == m-1) return steps;

            if(dist[rem][i][j] < steps) continue;

            for(int[] d : dirs){

                int ni = i + d[0];
                int nj = j + d[1];

                if(ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                int newK = rem - grid[ni][nj];
                if(newK < 0) continue;

                if(dist[newK][ni][nj] <= steps+1) continue;

                dist[newK][ni][nj] = steps+1;

                q.offer(new int[]{ni,nj,newK,steps+1});
            }
        }

        return -1;
    }
}
