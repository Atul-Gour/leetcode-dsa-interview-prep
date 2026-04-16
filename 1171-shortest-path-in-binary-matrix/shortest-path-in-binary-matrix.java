class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1; // mark visited

        int path = 1;

        int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,1},
            {1,-1},{1,0},{1,1}
        };

        while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s < size; s++){
                int[] curr = q.poll();
                int i = curr[0], j = curr[1];

                if(i == n-1 && j == n-1) return path;

                for(int[] d : dir){
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if(ni>=0 && nj>=0 && ni<n && nj<n && grid[ni][nj]==0){
                        grid[ni][nj] = 1;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
            path++;
        }

        return -1;
    }
}