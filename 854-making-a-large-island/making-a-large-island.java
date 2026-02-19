class DSU {

    int[] parent;
    int[] rank;

    DSU(int n) {
        parent = new int[n*n];
        rank = new int[n*n];

        for(int i = 0 ; i < n*n ; i++)parent[i] = i;
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

        int ra = rank[pa];
        int rb = rank[pb];

        if (ra < rb)
            parent[pa] = pb;
        else if (rb < ra)
            parent[pb] = pa;
        else {
            parent[pa] = pb;
            rank[pb]++;
        }

        return true;
    }
}

class Solution {

    static private int key(int a, int b) {
        return (int) a << 32 | b;
    }

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
                    dsu.parent[key] = key;
                    dsu.rank[key] = 0;

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
