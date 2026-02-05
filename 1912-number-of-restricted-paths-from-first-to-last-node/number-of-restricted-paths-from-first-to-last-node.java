class Solution {

    int MOD = 1_000_000_007;
    long[] dp;

    private long dfs(int curr, ArrayList<int[]>[] adj, int[] dist) {

        int n = dist.length - 1;

        if(curr == n) return 1;

        if(dp[curr] != -1) return dp[curr];

        long ways = 0;

        for(int[] neigh : adj[curr]) {

            int next = neigh[0];

            if(dist[curr] > dist[next]) {
                ways = (ways + dfs(next, adj, dist)) % MOD;
            }
        }

        return dp[curr] = ways;
    }

    public int countRestrictedPaths(int n, int[][] edges) {

        ArrayList<int[]>[] adj = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }

        // Dijkstra from node n
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.offer(new int[]{n,0});
        dist[n] = 0;

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();
            int u = curr[0];
            int w = curr[1];

            if(w > dist[u]) continue;

            for(int[] neigh : adj[u]) {
                int v = neigh[0];
                int wt = neigh[1];

                if(w + wt < dist[v]) {
                    dist[v] = w + wt;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // DP for counting paths
        dp = new long[n + 1];
        Arrays.fill(dp, -1);

        return (int) dfs(1, adj, dist);
    }
}
