class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        int[][] arr = new int[n][k + 1];

        for(int a[] : arr){
            Arrays.fill(a , Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            adj[flight[0]].add(new int[] { flight[1], flight[2] });
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        q.offer(new int[] { src, 0, 0 });
        arr[src][0] = 0;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int curr[] = q.poll();
            int currCity = curr[0];
            int currentStops = curr[1];
            int currCost = curr[2];

            if(currCost > ans)continue;

            for (int neigh[] : adj[currCity]) {
                int totalCost = currCost + neigh[1];

                if( arr[neigh[0]][currentStops] <= totalCost )continue;
                arr[neigh[0]][currentStops] = totalCost;

                if(totalCost > ans)continue;
                
                if (neigh[0] == dst) {
                    ans = Math.min(ans, totalCost);
                } else {
                    if(currentStops + 1 <= k) q.offer(new int[] { neigh[0], currentStops + 1, totalCost });
                }
            }

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}