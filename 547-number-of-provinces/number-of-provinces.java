class Solution {

    static private int findParent( int node , int[] parent ){
        if(parent[node] == node)
            return node;

        return parent[node] = findParent( parent[node] , parent );
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for( int i = 0 ; i < n ; i++ ){
            parent[i] = i;
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for( int j = 0 ; j < n ; j++ ){
                if( i != j && isConnected[i][j] != 0  ){
                    int parentA = findParent( i , parent );
                    int parentB = findParent( j , parent );
                    if( parentA == parentB )continue;

                    if( rank[parentA] <= rank[parentB] ){
                        if( rank[parentA] == rank[parentB] ) rank[parentB]++;
                        parent[parentA] = parentB;
                    }else{
                        parent[parentB] = parentA;
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(parent[i] == i) count++;
        }

        return count;
    }
}