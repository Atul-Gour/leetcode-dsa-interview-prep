class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length, m = grid[0].length;
        int count = 0;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    count++;

                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!q.isEmpty()) {
                        int[] cell = q.poll();

                        for (int[] d : dirs) {
                            int ni = cell[0] + d[0];
                            int nj = cell[1] + d[1];

                            if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == '1') {
                                q.offer(new int[]{ni, nj});
                                grid[ni][nj] = '0';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}