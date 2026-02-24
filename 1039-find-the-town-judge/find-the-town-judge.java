class Solution {
    public int findJudge(int n, int[][] trust) {
        
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        int[] indegree = new int[ n + 1];
        int[] outdegree = new int[n + 1];

        for( int i = 1 ; i <= n ; i++ ) adj[i] = new ArrayList<>();
        
        for( int[] t : trust ){
            int u = t[0];
            int v = t[1];

            adj[u].add( v );
            outdegree[u]++;
            indegree[v]++;
        } 

        for( int i = 1 ; i <= n ; i++ ){
            if( outdegree[i] == 0 && indegree[i] == n -1 )return i;
        }

        return -1;
    }
}