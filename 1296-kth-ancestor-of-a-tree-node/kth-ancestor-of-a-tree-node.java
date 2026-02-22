class TreeAncestor {
    int[] parent;
    int n;
    int[][] dp;
    final int MAX = 17;


    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.n = n;
        int[][] dp = new int[MAX][n];

        for( int j = 0 ; j < n ; j++ ){
            dp[0][j] = parent[j];
        }

        for( int i = 1 ; i < MAX ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( dp[i-1][j] == -1 ) dp[i][j] = -1;
                else dp[i][j] = dp[i-1][ dp[i-1][j] ];
            }
        }

        this.dp = dp;
    }
    
    public int getKthAncestor(int node, int k) {
        for( int i = 0 ; i < MAX ; i++ ){
            if(( k & ( 1 << i )) != 0 ){
                node = dp[i][node];
            }
            if( node == -1 )return node;
        }

        return node;
    }
}