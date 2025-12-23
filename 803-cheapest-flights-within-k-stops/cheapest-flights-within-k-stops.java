class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int cost[] = new int[n];

        Arrays.fill(cost , Integer.MAX_VALUE);

        cost[src] = 0;

        for(int i = 0 ; i <= k ; i++){

            int[] temp = cost.clone();

            for(int[] f: flights){
                int u = f[0] , v = f[1] , w = f[2];

                if (cost[u] != Integer.MAX_VALUE && cost[u] + w < temp[v]) {
                    temp[v] = cost[u] + w;
                }
            }

            cost = temp;
        }

        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst] ;
        
    }
}