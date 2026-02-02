class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        int[][] arr = new int[n][k + 1];

        for(int a[] : arr){
            Arrays.fill(a , Integer.MAX_VALUE);
        }

        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] flight : flights){
            adj[flight[0]].add(new int[]{ flight[1] , flight[2] });
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{src , 0});
        arr[src][0] = 0;

        int stop = 0;
        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty() && stop <= k){
            int size = q.size();

            while(size-- > 0){
                int curr[] = q.poll();
                int currCity = curr[0];
                int currCost = curr[1];

                for(int neigh[] : adj[currCity]){
                    int totalCost = currCost + neigh[1];

                    if( arr[neigh[0]][stop] <= totalCost )continue;
                    arr[neigh[0]][stop] = totalCost;

                    if(neigh[0] == dst){
                        ans = Math.min( ans , totalCost );
                    }else{
                        q.offer(new int[]{ neigh[0] , totalCost });
                    }
                }
            }
            
            stop++;            
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}