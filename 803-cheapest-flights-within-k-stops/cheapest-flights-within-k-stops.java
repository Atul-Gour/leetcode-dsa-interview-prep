class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] f : flights) {
            adj[f[0]].add(new int[]{f[1], f[2]});
        }

        // dist[city][stops] = min cost to reach city using stops stops
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{src, 0, 0}); // city, stops, cost
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int city = cur[0];
            int stops = cur[1];
            int cost = cur[2];

            if (city == dst) return cost;
            if (stops == k + 1) continue;

            for (int[] nei : adj[city]) {
                int next = nei[0];
                int price = nei[1];
                int newCost = cost + price;

                if (newCost < dist[next][stops + 1]) {
                    dist[next][stops + 1] = newCost;
                    pq.offer(new int[]{next, stops + 1, newCost});
                }
            }
        }

        return -1;
    }
}
