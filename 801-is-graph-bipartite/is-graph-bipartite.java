class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill( color , -1 );

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for( int i = 0 ; i < n ; i++ ){
            if( color[i] != -1 ) continue;

            q.offer( i );
            color[i] = 1;

            while( !q.isEmpty() ){
            int curr = q.poll();

            for( int neigh : graph[curr] ){
                if( color[neigh] == -1 ){
                    color[neigh]  = 1 - color[curr];
                    q.offer(neigh);
                }
                else if( color[neigh] == color[curr] ) return false;
            }
        }
        
        }
        return true;
    }
}