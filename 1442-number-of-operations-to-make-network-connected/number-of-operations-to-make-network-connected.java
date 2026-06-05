class Solution {

    static class DSU{
        int[] parent ;
        int[] size;

        DSU(int n){
            this.parent = new int[n];
            this.size = new int[n];

            for( int i = 0 ; i < n ; i++ ) parent[i] = i;
            Arrays.fill( size , 1 );
        }

        int find( int ele ){
            if( parent[ele] == ele ) return ele;
            return parent[ele] = find( parent[ele] );
        }

        boolean union( int a , int b ){
            int pa = find( a );
            int pb = find( b );

            if( pa == pb ) return false;

            int sizePa = size[pa];
            int sizePb = size[pb];

            if( sizePa < sizePb ){
                parent[pa] = parent[pb];
                size[pb] += size[pa];
            }
            else{
                parent[pb] = parent[pa];
                size[pa] += size[pb];
            }

            return true;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int extra = 0;
        DSU dsu = new DSU(n);

        for( int[] connection : connections ){
            if( !dsu.union( connection[0] , connection[1] ) ){
                extra++;
            }
        }

        int used = 0;

        for( int i = 1 ; i < n ; i++ ){
            if( dsu.union(0 , i) ){
                used++;
            }
        }

        if( used > extra ) return -1;
        return used;
    }
}









