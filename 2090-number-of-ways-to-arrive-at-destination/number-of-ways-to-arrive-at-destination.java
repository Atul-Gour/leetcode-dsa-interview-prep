class Solution {
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>( (long[] a , long[] b) -> Long.compare( a[1] , b[1] ) );
        
        long[] dist = new long[n];
        long[] ways = new long[n];

        int MOD = 1_000_000_007;

        Arrays.fill(dist , Long.MAX_VALUE);

        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() );

        for( int[] road : roads ){
            int u = road[0];
            int v = road[1];
            int d = road[2];

            graph.get(u).add( new int[]{ v , d } );
            graph.get(v).add( new int[]{ u , d } );
        }

        dist[0] = 0;
        ways[0] = 1;
        pq.offer( new long[]{0 , 0} );

        while( !pq.isEmpty() ){
            long[] curr = pq.poll();
            
            int currCity = (int)curr[0];
            long currDist = curr[1];

            if( dist[currCity] < currDist ) continue;

            for( int[] neigh : graph.get(currCity) ){
                int newCity = neigh[0];
                long newDist = currDist + neigh[1];

                if( dist[newCity] == newDist ){
                    ways[newCity] = ((long)ways[newCity] + ways[currCity]) % MOD;
                }
                else if( dist[newCity] > newDist ){
                    ways[newCity] = ways[currCity];
                    dist[newCity] = newDist;
                    pq.offer( new long[]{ newCity , newDist } );
                }
            }

        }
        
        return (int) ways[n-1];        
    }
}