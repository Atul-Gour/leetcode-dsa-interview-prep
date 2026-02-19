class DSU {

    HashMap<Long , Long> parent;
    HashMap<Long , Integer> size;

    DSU() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }

    long find(long node) {
        if (parent.get(node) == node)
            return node;
        
        long newParent = find(parent.get(node));
        parent.put( node , newParent );

        return newParent;
    }

    void union(long a, long b) {
        long pa = find(a);
        long pb = find(b);

        if (pa == pb) return;

        if (size.get(pa) < size.get(pb)) {
            parent.put(pa , pb);
            size.put(pb , size.get(pb) + size.get(pa) );
        } else {
            parent.put(pb , pa);
            size.put(pa , size.get(pa) + size.get(pb) );
        }
    }
}


class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        long[] rows = new long[10001];
        long[] cols = new long[10001];

        Arrays.fill( rows , -1 );
        Arrays.fill( cols , -1 );

        DSU dsu = new DSU();

        for( int[] stone :stones ){
            int x = stone[0];
            int y = stone[1];
            long key = x * n + y;

            dsu.parent.put( key , key );
            dsu.size.put( key , 1 );

            if( rows[x] == -1 ){
                rows[x] = key;
            }else{
                dsu.union( key , rows[x] );
            }

            if( cols[y] == -1 ){
                cols[y] = key;
            }else{
                dsu.union( key , cols[y] );
            }
        }

        HashMap<Long , Integer> freq = new HashMap<>();
        
        for( long node : dsu.parent.keySet() ){
            long nodeP = dsu.find( node );
            freq.put( nodeP , freq.getOrDefault( nodeP , 0 ) + 1 );
        }

        int ans = 0;

        for( int count : freq.values() ){
            if( count <= 1 )continue;
            ans += count - 1;
        }

        return ans;
    }
}