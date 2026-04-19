class Solution {

    static class DSU{
        Map<Integer , Integer> parent;
        Map<Integer , Integer> rank;

        DSU(){
            this.parent = new HashMap<>();
            this.rank = new HashMap<>();
        }
        
        int find( int node ){
            if( !parent.containsKey(node) ){
                parent.put(node , node);
                return node;
            }

            if( parent.get(node) == node ) return node;
            parent.put( node , find(parent.get(node)) );
            return parent.get(node);
        }

        boolean union( int a , int b ){
            int pa = find( a );
            int pb = find( b );

            if( pa == pb ) return false;

            int ra = rank.getOrDefault( pa , 0 );
            int rb = rank.getOrDefault( pb , 0 );

            if( ra < rb ){
                parent.put(pa , pb);
            }
            else if( rb < ra ){
                parent.put(pb , pa);
            }
            else{
                parent.put(pa , pb);
                rank.put( pb , rank.getOrDefault( pb , 0 ) + 1 );
            }

            return true;
        }
    }

    public int removeStones(int[][] stones) {
        Map<Integer , List<Integer> > xCoordinateMap = new HashMap<>();
        Map<Integer , List<Integer> > yCoordinateMap = new HashMap<>();
        Map<Integer , Integer> freq = new HashMap<>();
        DSU dsu = new DSU();

        for( int i = 0 ; i < stones.length ; i++ ){
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