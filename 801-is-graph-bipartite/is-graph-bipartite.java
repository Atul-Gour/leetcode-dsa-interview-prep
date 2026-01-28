class Solution {
    private boolean check( int node , int[][] graph , int[] color){
        int n = graph.length;

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 0;

        while(!q.isEmpty()){

            int curr = q.poll();
            
            for( int neigh : graph[curr]){

                if( color[neigh] == color[curr] ){
                    return false;
                }
                else if( color[neigh] == -1 ){
                    color[neigh] = 1 - color[curr];
                    q.offer( neigh );
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];

        Arrays.fill(color , -1);

        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(check( i , graph , color ) == false )
                    return false;
            }
        }
        return true;
    }
}