class Solution {

    private int find( int src , int distanceThreshold ,  ArrayList<ArrayList<int[]>> graph , int[] time , boolean[] visited ){
        Arrays.fill( time , -1 );
        int ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare( b[1] , a[1] ) );
        pq.offer( new int[]{src , distanceThreshold} );

        while( !pq.isEmpty() ){
            int[] curr = pq.poll();
            int node = curr[0];
            int currThreshold = curr[1];

            if( visited[node] )continue;

            visited[node] = true;
            if( node != src ) ans++;

            for( int[] neigh : graph.get(node) ){
                int neighNode = neigh[0];
                int weight = neigh[1];

                if( !visited[neighNode] &&  weight <= currThreshold && currThreshold - weight > time[neighNode] ){
                    time[neighNode] = currThreshold - weight;
                    pq.offer( new int[]{neighNode , currThreshold - weight} );
                }
            }
        }

        return ans;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() );

        for( int[] edge : edges ){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add( new int[]{v , w} );
            graph.get(v).add( new int[]{u , w} );
        }

        int ans = 0;
        int minNodesByAns = Integer.MAX_VALUE;

        for( int i = 0 ; i < n ; i++ ){
            int nodes = find( i , distanceThreshold , graph , new int[n] , new boolean[n] );

            if( nodes < minNodesByAns ){
                ans = i;
                minNodesByAns = nodes;
            }
            else if( nodes == minNodesByAns ) ans = Math.max( ans , i );
        }

        return ans;
    }
}