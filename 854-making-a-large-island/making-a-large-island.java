class DSU {
    int[] parent, rank, size;

    DSU(int n) {
        int N = n * n;
        parent = new int[N];
        rank = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else if (rank[pb] < rank[pa]) {
            parent[pb] = pa;
            size[pa] += size[pb];
        } else {
            parent[pa] = pb;
            size[pb] += size[pa];
            rank[pb]++;
        }
    }
}

class Solution {

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DSU dsu = new DSU(n);
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[][] matrix = new int[n][n];
        int[][] dirs = { { 0, -1 }, { -1, 0 } };

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int key = i * n + j;
                    int keyP = dsu.find(key);
                    freq.put(keyP, freq.getOrDefault(keyP, 0) + 1);
                    matrix[i][j] = keyP;
                    ans = Math.max(ans, freq.get(keyP));
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
                            set.add(matrix[newX][newY]);
                        }
                    }

                    for (int key : set) {
                        currAns += freq.get(key);
                    }

                    ans = Math.max(ans, currAns);
                }
            }
        }

        return ans;
    }
}