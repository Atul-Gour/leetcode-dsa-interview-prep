class Solution {
    public int countPaths(int n, int[][] roads) {
        long ans = 0;
        int MOD = 1_000_000_007;
        ArrayList<int[]>[] adj = new ArrayList[n];
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        long[] arr = new long[n];
        long[] ways = new long[n];

        Arrays.fill(arr, Long.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            adj[road[0]].add(new int[] { road[1], road[2] });
            adj[road[1]].add(new int[] { road[0], road[2] });
        }

        q.offer(new long[] { 0, 0 });
        arr[0] = 0;
        ways[0] = 1;

        while (!q.isEmpty()) {
            long curr[] = q.poll();
            int currNode = (int)curr[0];
            long currDist = curr[1];
            long currWays = ways[currNode];

            if (currDist > arr[currNode])
                continue;

            for (int neigh[] : adj[currNode]) {

                long totalDist = currDist + neigh[1];

                if (arr[neigh[0]] > totalDist) {
                    ways[neigh[0]] = (currWays) % MOD;
                    arr[neigh[0]] = totalDist;
                    q.offer(new long[] { neigh[0], totalDist });
                }
                else if( arr[neigh[0]] == totalDist ){
                    ways[neigh[0]] = (ways[neigh[0]] + currWays) % MOD;
                }

            }
        }

        return (int) ways[n-1];
    }
}