class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] totalTime = new int[n + 1];
        Arrays.fill(totalTime, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int cost = time[2];

            adj.get(from).add(new int[] { to, cost });
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        queue.offer(new int[] { k, 0 });
        totalTime[k] = 0;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int currTotalTime = pair[1];

            for (int[] neighbour : adj.get(node)) {
                int time = neighbour[1];
                int dest = neighbour[0];

                if (currTotalTime + time < totalTime[dest]) {
                    totalTime[dest] = currTotalTime + time;
                    queue.offer(new int[] { dest, totalTime[dest] });
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (totalTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, totalTime[i]);
        }

        return ans;
    }
}