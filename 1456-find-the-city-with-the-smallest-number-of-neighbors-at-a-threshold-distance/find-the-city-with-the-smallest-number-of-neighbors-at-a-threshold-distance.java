class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>( ( int[] a , int[] b ) -> Integer.compare(b[1] , a[1]) );

        for( int i = 0 ; i < n ; i++ ) graph.add( new ArrayList<>() );

        for( int[] edge : edges ){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add( new int[]{ v , w } );
            graph.get(v).add( new int[]{ u , w } );
        }

        int[] threshold = new int[n];

        int ansCity = 0;
        int ansCityVisited = n-1;

        for( int i = 0 ; i < n ; i++ ){

            Arrays.fill(threshold , -1);
            pq.clear();
            threshold[i] = distanceThreshold;

            pq.offer( new int[]{ i , distanceThreshold } );

            while( !pq.isEmpty() ){
                int curr[] = pq.poll();
                int currCity = (int) curr[0];
                int currThreshold = curr[1];

                if( threshold[currCity] > currThreshold ) continue;

                for( int[] neigh : graph.get(currCity) ){
                    
                    int newCity = neigh[0];
                    int newDist = neigh[1];
                    int newThreshold = currThreshold - newDist;

                    if( currThreshold < newDist || newThreshold <= threshold[newCity] ) continue;

                    threshold[newCity] = newThreshold;

                    if( newThreshold > 0 ){
                        pq.offer( new int[]{ newCity , newThreshold } );
                    }
                }
            }

            int currCityVisited = 0;
            
            for( int ind = 0 ; ind < n ; ind++ ){
                if( threshold[ind] != -1 && i != ind ) currCityVisited++;
            }

            if( currCityVisited <= ansCityVisited ){
                ansCity = i;
                ansCityVisited = currCityVisited;
            }
        }

        return ansCity;
    }
}