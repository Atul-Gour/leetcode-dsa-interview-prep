class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[V];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            indegree[u]++;
            graph.get(v).add(u);
        }

        for( int i = 0 ; i < V ; i++ ) if( indegree[i] == 0 ) q.offer(i);

        int processed = 0;
        while( !q.isEmpty() ){
            
            int node = q.poll();
            processed++;

            for( int neigh : graph.get(node) ){
                indegree[neigh]--;
                if( indegree[neigh] == 0 ) q.offer( neigh );
            }

        }

        return processed == V;

    }
}