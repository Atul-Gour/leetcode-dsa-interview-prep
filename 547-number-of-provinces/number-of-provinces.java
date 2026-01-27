class Solution {

    private void bfs( int node , boolean[] visited ,  ArrayList< ArrayList<Integer>> adj ){
        
        visited[node] = true;

        for( int u : adj.get( node )){
            if( !visited[u] ) bfs( u , visited , adj );
        }
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList< ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;

        for( int i = 0 ; i < n ; i++){
            adj.add( new ArrayList<>() );
        }

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( isConnected[i][j] == 1 ){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int ans = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if( visited[i] )continue;

            ans++;
            bfs( i , visited , adj );
        }

        return ans;
    }
}