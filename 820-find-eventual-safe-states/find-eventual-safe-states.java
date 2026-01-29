class Solution {

    private boolean dfsCheck(
            int node,
            int[][] graph,
            int[] vis,
            int[] pathVis,
            int[] check
    ) {

        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int neigh : graph[node]) {

            if (vis[neigh] == 0) {
                if (dfsCheck(neigh, graph, vis, pathVis, check)) {
                    return true;
                }
            }
            else if (pathVis[neigh] == 1) {
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, graph, vis, pathVis, check);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) ans.add(i);
        }

        return ans;
    }
}
