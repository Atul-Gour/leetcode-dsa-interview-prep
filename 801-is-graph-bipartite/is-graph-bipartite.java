class Solution {

    private boolean dfs( int node , int[][] graph , int[] color ){
        for( int neigh : graph[node] ){
            if( color[neigh] == 2 ){
                color[neigh] = (1 - color[node]);
                if( !dfs( neigh , graph , color ) ) return false;
            }
            else if( color[neigh] == color[node]) return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color , 2);

        for( int i = 0 ; i < n ; i++ ){
            if( color[i] == 2 ){
                color[i] = 1;
                if( !dfs( i , graph , color ) ) return false;
            }
        }

        return true;
    }
}