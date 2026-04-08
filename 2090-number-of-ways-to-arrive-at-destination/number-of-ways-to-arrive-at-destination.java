class Solution {

    static final long MOD = 1_000_000_007;

    static class Node{
        int node ;
        long time;

        Node( int node , long time ){
            this.node = node;
            this.time = time;
        }  
    }

    static private long dijkastra( int src , int dst , ArrayList<int[]>[] graph){

        int n = graph.length;
        
        PriorityQueue< Node > pq = new PriorityQueue<>( (a , b) -> Long.compare( a.time , b.time ) );
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill( dist , Long.MAX_VALUE );

        ways[src] = 1;
        dist[src] = 0;
        pq.offer( new Node( src , 0 ) );

        while( !pq.isEmpty() ){
            Node curr = pq.poll();
            int u = curr.node;
            long currTime = curr.time ;

            if( dist[u] < currTime ) continue;

            for( int[] neigh : graph[u] ){
                int v = neigh[0];
                long time = neigh[1];
                long newTime = currTime + time ;

                if( newTime == dist[v] ) ways[v] = (ways[u] + ways[v]) % MOD ;
                if( newTime >= dist[v] ) continue;

                if( newTime < dist[v] ) ways[v] = ways[u];

                dist[v] = newTime;

                pq.offer( new Node( v , newTime ) );

            }
        }

        return  ways[dst] % MOD;

    }

    public int countPaths(int n, int[][] roads) {
        boolean[] visited = new boolean[n];
        ArrayList<int[]>[] graph = new ArrayList[n];

        for( int i = 0 ; i < n ; i++ ) graph[i] = new ArrayList<>();

        for( int[] road : roads ){
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph[u].add( new int[]{ v , time } );
            graph[v].add( new int[]{ u , time } );
        }

        long cost = dijkastra( 0, n-1, graph );

        return (int)cost;
    }
}