class Solution {
    private class DSU{
        HashMap<Integer , int[]> map = new HashMap<>();

        private int find( int node ){
            if( map.get( node )[2] == node ) return node;
            
            int parent = find( map.get(node)[2] );
            map.get( node )[2] = parent;

            return parent;
        }

        private void update( int a , int b ){
            if( map.get( a )[0] - 1 == b ){
                map.get( a )[0] = b;
            }
            else{
                map.get( a )[1] = b;
            }
        }

        private int union( int a , int b ){

            int pa = find( a );
            int pb = find( b );

            if( pa == pb ) return 0;

            int sizeA = map.get( pa )[3];
            int sizeB = map.get( pb )[3];

            if( sizeA > sizeB ){
                map.get( pb )[2] = pa;
                map.get( pa )[3] += map.get( pb )[3];
                update( pa , b );
            }
            else{
                map.get( pa )[2] = pb;
                map.get( pb )[3] += map.get( pa )[3];
                update( pb , a );
            }

            return sizeA + sizeB;
        }
    }
    public int longestConsecutive(int[] nums) {

        DSU dsu = new DSU();
        int ans = 1;

        if( nums.length == 0 ) return 0;

        for( int ele : nums ){

            if( dsu.map.containsKey(ele) ) continue;

            dsu.map.put( ele , new int[]{ ele , ele , ele , 1 } );

            if( dsu.map.containsKey( ele - 1 ) ) ans = Math.max( ans , dsu.union(ele , ele - 1) );
            if( dsu.map.containsKey( ele + 1 ) ) ans = Math.max( ans , dsu.union(ele , ele + 1) );

        }

        return ans;
    }
}