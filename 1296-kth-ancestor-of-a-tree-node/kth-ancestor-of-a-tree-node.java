class TreeAncestor {
    int[][] table;
    final int MAX ;


    public TreeAncestor(int n, int[] parent) {

        this.MAX = (int)(Math.log(n)/Math.log(2)) + 1;
        int[][] table = new int[MAX][n];

        table[0] = parent;

        for( int i = 1 ; i < MAX ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( table[i-1][j] == -1 ) table[i][j] = -1;
                else table[i][j] = table[i-1][ table[i-1][j] ];
            }
        }

        this.table = table;
    }
    
    public int getKthAncestor(int node, int k) {
        for( int i = 0 ; i < MAX ; i++ ){
            if(( k & ( 1 << i )) != 0 ){
                node = table[i][node];
            }
            if( node == -1 )return node;
        }

        return node;
    }
}