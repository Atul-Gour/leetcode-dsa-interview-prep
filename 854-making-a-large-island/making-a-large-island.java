class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] id = new int[n][n];
        HashMap<Integer, Integer> sizeMap = new HashMap<>();

        int islandId = 2;
        int maxIsland = 0;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && id[i][j] == 0) {
                    int size = bfs(i, j, grid, id, islandId, dirs);
                    sizeMap.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }

        int ans = maxIsland;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;

                HashSet<Integer> seen = new HashSet<>();
                int curr = 1;

                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
                    if (id[ni][nj] == 0) continue;

                    if (seen.add(id[ni][nj])) {
                        curr += sizeMap.get(id[ni][nj]);
                    }
                }

                ans = Math.max(ans, curr);
            }
        }

        return ans;
    }

    private int bfs(int i, int j, int[][] grid, int[][] id, int islandId, int[][] dirs) {
        int n = grid.length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        id[i][j] = islandId;

        int size = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            size++;

            for (int[] d : dirs) {
                int ni = curr[0] + d[0];
                int nj = curr[1] + d[1];

                if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
                if (grid[ni][nj] == 0 || id[ni][nj] != 0) continue;

                id[ni][nj] = islandId;
                q.offer(new int[]{ni, nj});
            }
        }

        return size;
    }
}