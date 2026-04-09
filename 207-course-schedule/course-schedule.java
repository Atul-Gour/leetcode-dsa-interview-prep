class Solution {
    private boolean hasCycleDfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> graph) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neigh : graph.get(node)) {

            if (!visited[neigh]) {
                if (hasCycleDfs(neigh, visited, pathVisited, graph)) {
                    pathVisited[node] = false;
                    return true;
                }
            } 
            else if (pathVisited[neigh]) {
                pathVisited[node] = false;
                return true;
            }
        }

        pathVisited[node] = false; // normal backtrack
        return false;
    }

    public boolean canFinish(int V, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (hasCycleDfs(i, visited, pathVisited, graph)) return false;
            }
        }

        return true;
    }
}