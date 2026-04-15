class Solution {
    private int dfs( int node , int[][] graph , int[] visited ){

        if( visited[node] != 0 ) return visited[node];

        visited[node] = 1;

        for( int neigh : graph[node] ){
            if( dfs( neigh , graph , visited ) == 1 ){
                return 1;
            }
        }

        return visited[node] = 2;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        int[] visited = new int[n];

        List<Integer> ans = new ArrayList<>();

        for( int i = 0 ; i < n ; i++ ){
            if( dfs( i , graph , visited ) == 2 ) ans.add( i );
        }

        return ans;
    }
}