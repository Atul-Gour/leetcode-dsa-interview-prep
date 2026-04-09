class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            for (int[] d : dirs) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;

                if (ans[ni][nj] > ans[i][j] + 1) {
                    ans[ni][nj] = ans[i][j] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        return ans;
    }
}