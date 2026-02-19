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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DSU dsu = new DSU(n);

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( isConnected[i][j] == 1 ){
                    dsu.union(i , j);
                }
            }
        }

        return dsu.provinces();
    }
}