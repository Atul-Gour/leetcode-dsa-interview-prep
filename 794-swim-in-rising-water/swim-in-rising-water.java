class Solution {
    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) parent[pa] = pb;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int total = n * n;

        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{grid[i][j], i, j});
            }
        }

        Collections.sort(cells, (a, b) -> a[0] - b[0]);

        DSU dsu = new DSU(total);
        boolean[][] vis = new boolean[n][n];

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] cell : cells) {
            int h = cell[0], i = cell[1], j = cell[2];
            vis[i][j] = true;

            int id1 = i * n + j;

            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];

                if (ni<0 || nj<0 || ni>=n || nj>=n) continue;
                if (!vis[ni][nj]) continue;

                int id2 = ni * n + nj;
                dsu.union(id1, id2);
            }

            if (dsu.find(0) == dsu.find(n*n - 1)) {
                return h;
            }
        }
        return -1;
    }
}