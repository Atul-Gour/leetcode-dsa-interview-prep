class Solution {

    int time = 0;

    void dfs( int node , int parent, ArrayList<ArrayList<Integer>> graph , int[] low , int[] high , List<List<Integer>> ans ){
        
        low[node] = time;
        high[node] = time;
        time++;

        // System.out.println( node + " " + low[node] + " " + high[node] );

        for( int neigh : graph.get( node ) ){
            if( low[neigh] == -1 ){
                dfs( neigh , node , graph , low , high , ans );

                if( low[neigh] > high[node] ){
                    ans.add( new ArrayList<>( List.of(node , neigh) ) );
                }

                low[node] = Math.min( low[node] , low[neigh] );
            }
            else if( neigh != parent ){
                low[node] = Math.min( low[node] , low[neigh] );
            }
        }

        // System.out.println( node + " " + low[node] + " " + high[node] );
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() );

        for(List<Integer> connection : connections ){
            int a = connection.get(0);
            int b = connection.get(1);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] low = new int[n];
        int[] high = new int[n];

        Arrays.fill( low , -1 );
        Arrays.fill( high , -1 );

        for( int i = 0 ; i < n ; i++ ){
            if( low[i] == -1 ) dfs( i , -1 , graph , low , high , ans );
        }

        return ans;        
    }
}