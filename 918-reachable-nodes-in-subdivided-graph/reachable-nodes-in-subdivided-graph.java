class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] e : edges){
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }

        // max moves left when reaching node
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = maxMoves;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[1] - a[1]
        );

        pq.offer(new int[]{0, maxMoves});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int moves = curr[1];

            if(moves < dist[node]) continue;

            for(int[] nei : adj[node]){
                int next = nei[0];
                int cost = nei[1];

                int remain = moves - cost - 1;

                if(remain >= 0 && remain > dist[next]){
                    dist[next] = remain;
                    pq.offer(new int[]{next, remain});
                }
            }
        }

        int ans = 0;

        // Count original nodes
        for(int d : dist){
            if(d >= 0) ans++;
        }

        // Count subdivided nodes
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int k = e[2];

            int a = dist[u] < 0 ? 0 : dist[u];
            int b = dist[v] < 0 ? 0 : dist[v];

            ans += Math.min(k, a + b);
        }

        return ans;
    }
}
