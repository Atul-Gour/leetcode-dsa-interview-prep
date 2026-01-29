class Solution {

    private int dfs( int node , int[][] graph , int[] visited , boolean pathVisited[] ){

        if(visited[node] != 0)return visited[node];

        if( graph[node].length == 0 ) return visited[node] = 2;


        for( int neigh : graph[node] ){
            
            if( pathVisited[neigh] ){
                return visited[node] = 1;
            }

            pathVisited[neigh] = true;
            if( dfs( neigh , graph , visited , pathVisited ) == 1 ){
                pathVisited[neigh] = false;
                return visited[node] = 1;
            }
            pathVisited[neigh] = false;
        }

        return visited[node] = 2;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int V = graph.length;
        int[] visited = new int[V];
        boolean pathVisited[] = new boolean[V];

        for(int i = 0 ; i < V ; i++){
            if( visited[i] == 0 ){
                pathVisited[i] = true;
                visited[i] = dfs( i , graph , visited , pathVisited );
                pathVisited[i] = false;
            }
        }

        for(int i = 0 ; i < V ; i++){
            if( visited[i] == 2 )ans.add(i);
        }

        return ans;
    }
}