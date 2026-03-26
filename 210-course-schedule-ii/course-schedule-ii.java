class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        for( int i = 0 ; i < n ; i++ ) adj[i] = new ArrayList<>();

        for( int[] prerequisite : prerequisites ){
            adj[prerequisite[1]].add(prerequisite[0]);
        }

        int[] indegree = new int[n];

        for( int i = 0 ; i < n ; i++ ){
            for( int neigh : adj[i] ){
                indegree[neigh]++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for( int i = 0 ; i < n ; i++ ){
            if( indegree[i] == 0 )q.offer(i);
        }

        while( !q.isEmpty() ){
            int node = q.poll();

            for( int neigh : adj[node] ){
                indegree[neigh]--;

                if( indegree[neigh] == 0 )q.offer(neigh);
            }

            ans.add(node);
        }

        if( ans.size() != n )return new int[]{};

        int[] ansArray = new int[n];

        for( int i = 0 ; i < n ; i++ )ansArray[i] = ans.get(i);

        return ansArray;
    }
}