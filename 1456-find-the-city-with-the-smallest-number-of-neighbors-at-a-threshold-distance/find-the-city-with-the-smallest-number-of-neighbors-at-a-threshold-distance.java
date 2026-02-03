class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {

        ArrayList<int[]>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>();

        for(int[] e : edges){
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }

        int answer = 0;
        int minReachable = Integer.MAX_VALUE;

        for(int src = 0; src < n; src++){

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)->a[1]-b[1]);

            pq.offer(new int[]{src,0});

            while(!pq.isEmpty()){

                int[] curr = pq.poll();
                int node = curr[0];
                int d = curr[1];

                if(d > dist[node]) continue;

                for(int[] neigh : adj[node]){
                    int newDist = d + neigh[1];

                    if(newDist < dist[neigh[0]]){
                        dist[neigh[0]] = newDist;
                        pq.offer(new int[]{neigh[0], newDist});
                    }
                }
            }

            int reachable = 0;
            for(int i=0;i<n;i++){
                if(i != src && dist[i] <= threshold) reachable++;
            }

            if(reachable <= minReachable){
                minReachable = reachable;
                answer = src;
            }
        }

        return answer;
    }
}
