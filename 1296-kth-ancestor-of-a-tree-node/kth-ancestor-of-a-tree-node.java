class TreeAncestor {

    final int max = 17;
    static int table[][];

    void build( int[] parent ){
        int n = parent.length;

        for(int i = 0 ; i < n ; i++ ){
            table[i][0] = parent[i];
        }

        for(int j = 1 ; j < max ; j++ ){
            for(int i = 0 ; i < n ; i++ ){
                int mid = table[i][j-1];

                if(mid == -1)
                    table[i][j] = -1;
                else 
                    table[i][j] = table[mid][j-1];
            }
        }
    }

    public TreeAncestor(int n, int[] parent) {
        table = new int[n][max];
        build(parent);
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i = 0 ; i < max ; i++ ){
            if( ( k & (1 << i)) != 0){
                node = table[node][i];
            }
            if(node == -1)return -1;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */