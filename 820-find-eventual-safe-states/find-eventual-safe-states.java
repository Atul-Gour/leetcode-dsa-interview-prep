class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int outdegree[] = new int[n];
        Queue<Integer> q = new ArrayDeque<>();

        for( int i = 0 ; i < n ; i++ ){
            outdegree[i] = graph[i].length;
            if( outdegree[i] == 0 ){
                q.offer( i );
            }
        }
        
        ArrayList<Integer>[] adj = new ArrayList[n];

        for( int i = 0 ; i < n ; i++ ){
            adj[i] = new ArrayList<>();
        }

        for( int i = 0 ; i < n ; i++ ){
            for( int neigh : graph[i] ){
                adj[neigh].add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] safe = new boolean[n];

        while( !q.isEmpty() ){
            int curr = q.poll();
            safe[curr] = true;

            for( int neigh : adj[curr] ){
                // if( safe[neigh] )continue;
                outdegree[neigh]--;
                if( outdegree[neigh] == 0 ) q.offer(neigh);
            }
        }

        for( int i = 0 ; i < n ; i++ ){
            if( safe[i] )ans.add(i);
        }

        return ans;
    }
}