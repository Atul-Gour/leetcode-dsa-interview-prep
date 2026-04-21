class Solution {


    static int[] low;
    static int[] time;
    static int t = 0;

    void dfs( int node , int parent , List<List<Integer>> ans , List<List<Integer>> graph ){

        time[node] = t;
        low[node] = t;
        t++;

        for( int neigh : graph.get(node) ){
            if( time[neigh] == -1 ){
                dfs( neigh , node , ans , graph );
                low[node] = Math.min( low[node] , low[neigh] );
                if( low[neigh] > time[node] )  ans.add( new ArrayList<>(List.of(node , neigh)) );
            }
            else if( neigh != parent ){
                low[node] = Math.min( low[node] , time[neigh] );
            }

            
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.low = new int[n];
        this.time = new int[n];
        t = 0;

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() );
        Arrays.fill( time , -1 );

        for( List<Integer> connection : connections ){
            int u = connection.get(0);
            int v = connection.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for( int i = 0 ; i < n ; i++ ){
            if( time[i] == -1 ){
                dfs( i , -1 , ans , graph );
            }
        }

        return ans;
    }
}