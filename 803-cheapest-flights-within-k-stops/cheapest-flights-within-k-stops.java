class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(
                new int[]{flight[1], flight[2]}
            );
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{src, 0, 0}); // city, cost, stops
        dist[src] = 0;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int city = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (stops > k) continue;

            for (int[] neigh : graph.get(city)) {

                int nextCity = neigh[0];
                int nextCost = cost + neigh[1];

                if (nextCost < dist[nextCity]) {

                    dist[nextCity] = nextCost;

                    q.offer(
                        new int[]{
                            nextCity,
                            nextCost,
                            stops + 1
                        }
                    );
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }
}