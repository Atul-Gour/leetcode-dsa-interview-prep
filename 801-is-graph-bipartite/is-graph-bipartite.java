class Solution {
    private boolean check(int curr, int[][] graph, int[] color) {

        for (int neigh : graph[curr]) {

            if (color[neigh] == color[curr]) {
                return false;
            } else if (color[neigh] == -1) {
                color[neigh] = 1 - color[curr];
                if( check( neigh , graph , color ) == false )return false;
            }

        }
        return true;

    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];

        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (check(i, graph, color) == false)
                    return false;
            }
        }
        return true;
    }
}