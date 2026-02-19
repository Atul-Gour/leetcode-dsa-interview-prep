class DSU {

    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = find(parent[node]);
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return false;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }

        return true;
    }
}

class Solution {

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DSU dsu = new DSU(n*n);
        int[][] dirs = { { 0, -1 }, { -1, 0 } };
        // int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int key = i * n + j;

                    for (int d[] : dirs) {
                        int newX = i + d[0];
                        int newY = j + d[1];

                        if (newX < n && newX >= 0 && newY < n && newY >= 0 && grid[newX][newY] == 1) {
                            int newKey = newX * n + newY;
                            dsu.union(key, newKey);
                        }
                    }

                }
            }
        }

        int[][] dirss = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {

                    int currAns = 1;

                    HashSet<Integer> set = new HashSet<>();

                    for (int[] d : dirss) {
                        int newX = i + d[0];
                        int newY = j + d[1];

                        if (newX < n && newX >= 0 && newY < n && newY >= 0 && grid[newX][newY] == 1) {
                            int parent = dsu.find(newX * n + newY);
                            set.add(parent);
                        }
                    }

                    for (int key : set) {
                        currAns += dsu.size[key];
                    }

                    ans = Math.max(ans, currAns);
                }
            }
        }

        for (int i = 0; i < n * n; i++) {
            if (dsu.find(i) == i) {
                ans = Math.max(ans, dsu.size[i]);
            }
        }

        return ans;
    }
}
