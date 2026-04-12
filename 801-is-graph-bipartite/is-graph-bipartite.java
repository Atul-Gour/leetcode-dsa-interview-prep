import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!dfs(i, graph, color))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int[][] graph, int[] color) {

        for (int neigh : graph[node]) {

            if (color[neigh] == -1) {

                color[neigh] = 1 - color[node];
                if (!dfs(neigh, graph, color))
                    return false;

            } else if (color[neigh] == color[node])
                return false;
        }
        return true;
    }
}