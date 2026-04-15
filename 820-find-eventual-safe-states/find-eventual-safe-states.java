class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph2) {
        int n = graph2.length;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        boolean[] isSafe = new boolean[n];

        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() );

        for( int i = 0 ; i < n ; i++ ){
            for( int neigh : graph2[i] ){
                graph.get(neigh).add(i);
                indegree[i]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for( int i = 0 ; i < n ; i++ ) if( indegree[i] == 0 ) queue.offer( i );

        while( !queue.isEmpty() ){
            int node = queue.poll();
            isSafe[node] = true;

            for( int neigh : graph.get( node ) ){
                indegree[neigh]--;
                if( indegree[neigh] == 0 ) queue.offer( neigh );
            }
        }

        for( int i = 0 ; i < n ; i++ ){
            if( isSafe[i] ) ans.add(i);
        }

        return ans;
    }
}