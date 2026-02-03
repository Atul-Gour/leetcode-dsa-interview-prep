class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double ans = 0;

        ArrayList<double[]>[] adj = new ArrayList[n];
        double[] probability = new double[n];
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare( b[1] , a[1] ));

        for(int i = 0 ; i < n ; i++) adj[i] = new ArrayList<>();

        for( int i = 0 ; i < edges.length ; i++){
            adj[edges[i][0]].add(new double[]{ edges[i][1] , succProb[i] });
            adj[edges[i][1]].add(new double[]{ edges[i][0] , succProb[i] });
        }

        probability[start_node] = 1;
        pq.offer( new double[]{ start_node , 1 });

        while( !pq.isEmpty() ){
            double curr[] = pq.poll();
            int node = (int)curr[0];
            double currProb = curr[1];

            if(probability[node] > currProb)continue;

            for( double[] neigh : adj[node] ){
                int neighNode = (int)neigh[0];
                double newProb = currProb * neigh[1];
                if( probability[ neighNode ] < newProb ){
                    probability[ neighNode ] = newProb;
                    pq.offer(new double[]{ neighNode , newProb });
                }
            }
        }
    
 
        return probability[end_node];
    }
}