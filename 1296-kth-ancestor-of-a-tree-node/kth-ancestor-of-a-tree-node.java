class TreeAncestor {
    int[] parent;
    int n;
    int[][] dp;


    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.n = n;
        int[][] dp = new int[20][n];

        for( int j = 0 ; j < n ; j++ ){
            dp[0][j] = parent[j];
        }

        for( int i = 1 ; i < 20 ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( dp[i-1][j] == -1 ) dp[i][j] = -1;
                else dp[i][j] = dp[i-1][ dp[i-1][j] ];
            }
        }

        this.dp = dp;
    }
    
    public int getKthAncestor(int node, int k) {
        int i = 0;
        while( k > 0 ){
            
            if( (k & 1) == 0 ){
                k >>= 1;
                i++;
                continue;
            }
            node = dp[i][node];
            if(node == -1)return -1;

            k >>= 1;
            i++;
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */