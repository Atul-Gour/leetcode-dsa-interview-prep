class Solution {

    static private boolean dfs( int node , int[][] graph , int[] visited  , boolean[] safe){
        if( visited[node] == 2 )return safe[node];
        
        visited[node] = 1;

        for( int neigh : graph[node] ){

            if( visited[neigh] == 1 ){
                visited[node] = 2;
                return safe[node] = false;
            }
            else{
                if( !dfs( neigh , graph , visited , safe ) ){
                    visited[node] = 2;
                    return safe[node] = false;
                }
            }
            
        }

        visited[node] = 2;
        return safe[node] = true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        boolean[] safe = new boolean[n];
        int[] visited = new int[n];      

        for( int i = 0 ; i < n ; i++ ){
            if( visited[i] == 0 ){
                dfs( i , graph , visited , safe );
            }
        }

        List<Integer> ans = new ArrayList<>();

        for( int i = 0 ; i < n ; i++ ){
            if( safe[i] )ans.add(i);
        }

        return ans;
    }
}