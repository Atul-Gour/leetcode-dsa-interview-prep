class Solution {
    private long key(int a , int b){
        return ((long) a << 32) | b;
    }
    public int networkDelayTime(int[][] edges, int V, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> Integer.compare(a[1],b[1]));
        
        ArrayList<Integer>[] adj = new ArrayList[V + 1];
        HashMap<Long , Integer> distCost = new HashMap<>();
        for(int  i = 1 ; i <= V ; i++ ){
            adj[i] = new ArrayList<>();
        }
        for( int[] e : edges){
            adj[ e[0] ].add( e[1] );            
            distCost.put( key(e[0] ,e[1]) , e[2] ); 
        }
        
        int[] ans = new int[V + 1];
        Arrays.fill( ans , Integer.MAX_VALUE);
        
        ans[src] = 0;
        
        pq.add(new int[]{src , 0});
        
        while( !pq.isEmpty() ){
            int curr[] = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];
            if (currDist > ans[currNode]) continue;   
            for( int neigh : adj[currNode] ){
                int currToNeigh = distCost.get( key(currNode ,neigh) );
                if( ans[neigh] > currDist + currToNeigh){
                    ans[neigh] = currDist + currToNeigh;
                    pq.offer( new int[]{ neigh , ans[neigh] } );
                }
            }
        }
        int max = -1;
        ans[0] = 0;
        for(int i : ans){
            max = Math.max(max , i);
        }
        
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}