class Solution {

    private boolean dfs(
            int node,
            int[][] graph,
            boolean[] vis,
            boolean[] pathVis,
            boolean[] safe
    ) {

        vis[node] = true;
        pathVis[node] = true;
        safe[node] = false; // assume unsafe

        for (int neigh : graph[node]) {
            if (!vis[neigh]) {
                if (dfs(neigh, graph, vis, pathVis, safe)) {
                    return true;
                }
            } else if (pathVis[neigh]) {
                return true; // cycle
            }
        }

        safe[node] = true;   // proven safe
        pathVis[node] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, graph, vis, pathVis, safe);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) ans.add(i);
        }
        return ans;
    }
}
