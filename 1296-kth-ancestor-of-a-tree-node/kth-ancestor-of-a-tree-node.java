class TreeAncestor {

    int[][] parent;
    int LOG = 20;

    public TreeAncestor(int n, int[] p) {
        parent = new int[n][LOG];

        for (int i = 0; i < n; i++) {
            parent[i][0] = p[i];
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int mid = parent[i][j - 1];
                if (mid == -1)
                    parent[i][j] = -1;
                else
                    parent[i][j] = parent[mid][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                node = parent[node][j];
                if (node == -1) return -1;
            }
        }
        return node;
    }
}
