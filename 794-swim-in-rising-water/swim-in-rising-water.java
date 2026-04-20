class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int low = grid[0][0], high = n * n - 1;
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canReach(grid, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canReach(int[][] grid, int t) {
        int n = grid.length;
        if (grid[0][0] > t) return false;

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];

            if (i == n-1 && j == n-1) return true;

            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];

                if (ni<0 || nj<0 || ni>=n || nj>=n) continue;
                if (vis[ni][nj] || grid[ni][nj] > t) continue;

                vis[ni][nj] = true;
                q.offer(new int[]{ni, nj});
            }
        }
        return false;
    }
}