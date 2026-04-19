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

    public int makeConnected(int n, int[][] connections) {
        int edgesSize = connections.length;
        DSU dsu = new DSU(n);

        if( edgesSize < n - 1 ) return -1;
        int edgesWaste = 0;

        for( int[] edge : connections ){
            if( !dsu.union( edge[0] , edge[1] ) ) edgesWaste++;
        }

        int edgesNeed = 0;
        for( int i = 0 ; i < n ; i++ ){
            if( dsu.union( 0 , i ) ) edgesNeed++;
        }

        return edgesNeed;        
    }
}