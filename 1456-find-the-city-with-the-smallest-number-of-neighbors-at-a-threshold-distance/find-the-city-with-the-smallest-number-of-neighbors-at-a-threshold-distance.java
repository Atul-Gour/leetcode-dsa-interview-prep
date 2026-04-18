class Solution {

    private int dijkstra(int src, int n, ArrayList<ArrayList<int[]>> graph, int threshold) {

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dist[node]) continue;

            for (int[] neigh : graph.get(node)) {
                int next = neigh[0];
                int weight = neigh[1];

                if (d + weight < dist[next]) {
                    dist[next] = d + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= threshold) count++;
        }

        return count;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int result = -1;
        int minReach = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachable = dijkstra(i, n, graph, distanceThreshold);

            if (reachable <= minReach) {
                minReach = reachable;
                result = i;
            }
        }

        return result;
    }
}