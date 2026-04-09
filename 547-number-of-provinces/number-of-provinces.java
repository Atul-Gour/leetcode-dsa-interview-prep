class Solution {

    private void dfs( int node , ArrayList<Integer>[] graph , boolean[] visited ){

        for( int neigh : graph[node] ){

            if( !visited[neigh] ){
                visited[neigh] = true;
                dfs( neigh , graph , visited );
            }
                
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];

        for( int i = 0 ; i < n ; i++ ) graph[i] = new ArrayList<>();

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( isConnected[i][j] == 1 ) graph[i].add(j);
            }
        }

        int ans = 0;

        boolean[] visited = new boolean[n];
        for( int i = 0 ; i < n ; i++ ){
            if( !visited[i] ){
                visited[i] = true;
                dfs( i , graph , visited );
                ans++;
            }
        }
        
        return ans;
    }
}