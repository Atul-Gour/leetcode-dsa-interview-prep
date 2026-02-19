class Solution {
    static private int findParent( int node ,int[] parent ){
        if( parent[node] == node )
            return node;

        return parent[node] = findParent( parent[node] , parent );
    }

    static boolean union( int a , int b , int[] parent , int[] rank ){
        int parentA = findParent(a , parent);
        int parentB = findParent(b , parent);
        if( parentA == parentB ) return true;

        int rankA = rank[parentA];
        int rankB = rank[parentB];

        if( rankA == rankB ){
            parent[parentB] = parentA;
            rank[parentA]++;
        }else if( rankA < rankB ){
            parent[parentA] = parentB;
        }else{
            parent[parentB] = parentA;
        }

        return false;
    }


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for( int i = 0 ; i <= n ; i++ )parent[i] = i;

        for( int edge[] : edges ){
            if( union( edge[0] , edge[1] , parent , rank ) ){
                return new int[]{edge[0] , edge[1]};
            }
        }

        return new int[]{0 , 0};
    }
}