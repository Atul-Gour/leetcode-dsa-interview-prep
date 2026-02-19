class Solution {

    static class DSU{

        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for( int i = 0 ; i < n ; i++ ) parent[i] = i;
        }

        int find( int node ){
            if( parent[node] == node )return node;
            return parent[node] = find( parent[node] );
        }

        boolean union( int a , int b ){
            int pa = find(a);
            int pb = find(b);

            if( pa == pb )return false;

            int ra = rank[pa];
            int rb = rank[pb];

            if( ra < rb )parent[pa] = pb;
            else if( rb < ra )parent[pb] = pa;
            else{
                parent[pa] = pb;
                rank[pb]++;
            }

            return true;
        }

        int provinces(){
            int count = 0;
            for( int i = 0 ; i < parent.length ; i++ ){
                int pCurr = find(parent[i]);
                if( pCurr == i )count++;
            }

            return count;
        }

    }

    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);

        int redundantCablesCount = 0;
        for( int edge[] : connections ){
            if( !dsu.union( edge[0] , edge[1] ) ){
                redundantCablesCount++;
            }
        }

        int provinces = dsu.provinces();

        if( redundantCablesCount < provinces - 1 )return -1;
        else return provinces - 1;
    }
}