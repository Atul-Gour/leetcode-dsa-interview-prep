class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList< ArrayList<int[]> > graph = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[1] , b[1]));
        int[][] dist = new int[n][k + 2];


        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() );
        for( int flight[] : flights ) graph.get(flight[0]).add( new int[]{ flight[1] , flight[2] } );

        for( int[] d : dist ) Arrays.fill( d , Integer.MAX_VALUE );

        dist[src][0] = 0;
        pq.offer( new int[]{ src , 0 , 0 } );

        while( !pq.isEmpty() ){
            int curr[] = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            // System.out.println( node + " " + cost + " " + stops );

            if( node == dst ) return cost;
            if( stops > k || dist[node][stops] < cost ) continue;

            for( int[] neigh : graph.get(node) ){
                int v = neigh[0];
                int newFare = cost + neigh[1];

                if( dist[v][stops + 1] > newFare ){
                    dist[v][stops + 1] = newFare;
                    pq.offer( new int[]{ v , newFare , stops + 1 } );
                }
            }
        }

        return -1;
    }
}