class Solution {
    public int shortestPath(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        if(n == 1 && m == 1) return 0;

        // visited[i][j] = maximum k remaining seen so far
        int[][] visited = new int[n][m];
        for(int[] row : visited) Arrays.fill(row, -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,k});

        visited[0][0] = k;

        int steps = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];
                int rem = curr[2];

                if(i == n-1 && j == m-1) return steps;

                for(int[] d : dirs){

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if(ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                    int newK = rem - grid[ni][nj];
                    if(newK < 0) continue;

                    if(visited[ni][nj] >= newK) continue;

                    visited[ni][nj] = newK;
                    q.offer(new int[]{ni,nj,newK});
                }
            }

            steps++;
        }

        return -1;
    }
}
