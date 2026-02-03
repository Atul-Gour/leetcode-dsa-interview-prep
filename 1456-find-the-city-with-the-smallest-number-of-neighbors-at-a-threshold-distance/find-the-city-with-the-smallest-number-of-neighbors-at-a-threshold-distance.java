class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<int[]>[] adj = new ArrayList[n];

        for(int i = 0 ; i < n ; i++) adj[i] = new ArrayList<>();

        for( int[] edge : edges ){
            if( edge[2] > distanceThreshold )continue;
            adj[ edge[0] ].add( new int[]{ edge[1] , edge[2] } );
            adj[ edge[1] ].add( new int[]{ edge[0] , edge[2] } );
        }
        Queue<int[]> q = new ArrayDeque<>();
        int cost[] = new int[n];

        int ans = 0;
        int ansScore = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            int currScore = 0;
            q.offer( new int[]{ i , 0 } );

            Arrays.fill( cost , Integer.MAX_VALUE );
            cost[i] = 0;
            
            while( !q.isEmpty() ){
                int curr[] = q.poll();
                int currNode = curr[0];
                int currCost = curr[1];

                if( cost[ currNode ] < currCost )continue;

                for( int neigh[] : adj[currNode] ){
                    int totalCost = currCost + neigh[1] ;
                    if( cost[neigh[0]] > totalCost && totalCost <= distanceThreshold ){
                        if( cost[neigh[0]] == Integer.MAX_VALUE )currScore++;
                        cost[neigh[0]] = totalCost;
                        if( totalCost < distanceThreshold ) q.offer( new int[]{ neigh[0] , totalCost } );
                    }
                }
            }

            if( currScore < ansScore ){
                ansScore = currScore;
                ans = i;
            }else if(currScore == ansScore ){
                ans = Math.max ( ans , i );
            }
        }
        return ans;
    }
}