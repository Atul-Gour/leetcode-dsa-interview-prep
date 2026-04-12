class Solution {
    private boolean find(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> graph , Stack<Integer> st ) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neigh : graph.get(node)) {

            if (!visited[neigh]) {
                if (find(neigh, visited, pathVisited, graph , st)) {
                    pathVisited[node] = false;
                    return true;
                }
            } 
            else if (pathVisited[neigh]) {
                pathVisited[node] = false;
                return true;
            }
        }

        st.push( node );
        pathVisited[node] = false;
        return false;
    }

    public int[] findOrder(int V, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[V];

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
                if (find(i, visited, pathVisited, graph , st )) return new int[0];
            }
        }

        ArrayList<Integer> list = new ArrayList<>(st);
        Collections.reverse( list );
        for( int i = 0 ; i < V ; i++ ) ans[i] = list.get(i);

        return ans;
    }
}