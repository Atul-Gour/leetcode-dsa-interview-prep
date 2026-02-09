class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer>[] adj;
    int[] tin, low;
    boolean[] visited;
    int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (List<Integer> e : connections) {
            int u = e.get(0);
            int v = e.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        tin = new int[n];
        low = new int[n];
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]) dfs(i, -1);
        }

        return ans;
    }

    private void dfs(int u, int parent) {

        visited[u] = true;
        tin[u] = low[u] = timer++;

        for (int v : adj[u]) {

            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > tin[u]) {
                    ans.add(Arrays.asList(u, v));
                }

            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }
    }
}
