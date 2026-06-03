class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList< ArrayList< int[] >> edges = new ArrayList<>();

        ArrayDeque<int[]> pq = new ArrayDeque<>();

        int[] cost = new int[n];

        for( int i = 0 ; i < n ; i++ ) edges.add( new ArrayList<>() );

        for( int[] flight: flights ){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            edges.get( from ).add( new int[]{ to , price } );
        }

        Arrays.fill( cost , Integer.MAX_VALUE );
        
        pq.offer( new int[]{src , 0} );
        cost[src] = 0;

        while( !pq.isEmpty() && k >= 0 ){
            int size = pq.size();
            // System.out.println();

            while( size-- > 0 ){
                int curr[] = pq.poll();
                int currCity = curr[0];
                int currCost = curr[1];

                // if( currCost > cost[currCity] ) continue;

                // System.out.println(currCity + " curr cost =  " + currCost);

                for( int[] neigh : edges.get(currCity) ){

                    int newCity = neigh[0];
                    int newCost = neigh[1] + currCost;

                    if( newCost < cost[newCity] ){
                        // System.out.println(newCity + " cost =  " + newCost);
                        cost[newCity] = newCost;
                        pq.offer( new int[]{ newCity , newCost } );
                    }

                }
            }

            k--;
        }

        return cost[dst] != Integer.MAX_VALUE ? cost[dst] : -1;
    }
}