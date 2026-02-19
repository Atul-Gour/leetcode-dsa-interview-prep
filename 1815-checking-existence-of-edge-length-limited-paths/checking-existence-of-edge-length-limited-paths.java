import java.util.*;

class Solution {

    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return;

            if (rank[pa] < rank[pb])
                parent[pa] = pb;
            else if (rank[pb] < rank[pa])
                parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public boolean[] distanceLimitedPathsExist(int n,
                                               int[][] edgeList,
                                               int[][] queries) {

        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        int q = queries.length;

        int[][] q2 = new int[q][4];

        for (int i = 0; i < q; i++) {
            q2[i][0] = queries[i][0];
            q2[i][1] = queries[i][1];
            q2[i][2] = queries[i][2];
            q2[i][3] = i;
        }

        Arrays.sort(q2, (a, b) -> a[2] - b[2]);

        boolean[] ans = new boolean[q];

        DSU dsu = new DSU(n);

        int edgeIndex = 0;

        for (int i = 0; i < q; i++) {

            int limit = q2[i][2];

            while (edgeIndex < edgeList.length &&
                   edgeList[edgeIndex][2] < limit) {

                dsu.union(edgeList[edgeIndex][0],
                          edgeList[edgeIndex][1]);

                edgeIndex++;
            }

            int u = q2[i][0];
            int v = q2[i][1];
            int originalIndex = q2[i][3];

            ans[originalIndex] =
                    dsu.find(u) == dsu.find(v);
        }

        return ans;
    }
}