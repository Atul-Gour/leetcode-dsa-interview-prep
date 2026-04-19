class Solution {

    static class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for( int i = 0 ; i < n ; i++ ) parent[i] = i;
        }
        
        int find( int node ){
            if( parent[node] == node ) return node;
            return parent[node] = find( parent[node] );
        }

        boolean union( int a , int b ){
            int pa = find( a );
            int pb = find( b );

            if( pa == pb ) return false;

            int ra = rank[pa];
            int rb = rank[pb];

            if( ra < rb ){
                parent[pa] = pb;
            }
            else if( rb < ra ){
                parent[pb] = pa;
            }
            else{
                parent[pa] = pb;
                rank[pb]++;
            }

            return true;
        }
    }

    public int removeStones(int[][] stones) {
        Map<Integer , List<Integer> > xCoordinateMap = new HashMap<>();
        Map<Integer , List<Integer> > yCoordinateMap = new HashMap<>();
        Map<Integer , Integer> freq = new HashMap<>();

        int n = stones.length;
        DSU dsu = new DSU(n);

        for( int i = 0 ; i < n ; i++ ){
            int x = stones[i][0];
            int y = stones[i][1];

            xCoordinateMap.computeIfAbsent( x , f -> new ArrayList<>() ).add(i);
            yCoordinateMap.computeIfAbsent( y , f -> new ArrayList<>() ).add(i);
        }

        for( List<Integer> list : xCoordinateMap.values() ){
            for( int i = 1 ; i < list.size() ; i++ ){
                dsu.union( list.get( i - 1 ) , list.get(i) );
            }
        }
        for( List<Integer> list : yCoordinateMap.values() ){
            for( int i = 1 ; i < list.size() ; i++ ){
                dsu.union( list.get( i - 1 ) , list.get(i) );
            }
        }

        System.out.println(dsu.parent);

        for( int i = 0 ; i < stones.length ; i++ ){
            int parent = dsu.find(i);
            freq.put( parent , freq.getOrDefault(parent , 0) + 1 );
        }

        int ans = 0;
        for( int count : freq.values() ){
            ans += count - 1;
        }

        return ans;
    }
}