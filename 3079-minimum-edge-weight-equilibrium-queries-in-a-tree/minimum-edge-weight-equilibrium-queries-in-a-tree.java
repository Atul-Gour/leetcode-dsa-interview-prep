class Solution {

    void build( int node , int parent , int wt , int[][] freq , ArrayList<int[]>[] adj ){

        if( parent != -1 ){
            for( int i = 0 ; i < 27 ; i++ ){
                freq[node][i] = freq[parent][i];
            }
            freq[node][wt]++;
        }

        for( int[] neigh : adj[node] ){
            if( neigh[0] == parent )continue;
            build( neigh[0] , node , neigh[1] , freq , adj );
        }
    
    }

    int solve( int[] query , int[][] freq , int lca ){

        int maxFreq = Integer.MIN_VALUE;
        int a = query[0];
        int b = query[1];

        int totalChar = 0;

        for( int i = 1 ; i < 27 ; i++ ){
            int curr = freq[a][i] + freq[b][i] - ( freq[lca][i] * 2 );
            totalChar += curr;
            maxFreq = Math.max( maxFreq , curr );
        }

        return totalChar - maxFreq;
    }

    void buildParent( int[][] parent , int[] depth , ArrayList<int[]>[] adj , int MAX ){
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer( new int[]{0 , -1} );
        int height = 0;

        while( !q.isEmpty() ){
            int n = q.size();

            for( int i = 0 ; i < n ; i++ ){
                int c[] = q.poll();
                int curr = c[0];
                depth[curr] = height;
                parent[0][curr] = c[1];

                for( int[] neigh : adj[curr] ){
                    if( neigh[0] == c[1] )continue;
                    q.offer( new int[]{neigh[0] , curr} );
                }
            }

            height++;
        }

        

        // lca table creation

        for( int i = 1 ; i < MAX ; i++ ){
            for( int j = 0 ; j < parent[0].length ; j++ ){
                int mid = parent[i-1][j];

                if( mid == -1 )parent[i][j] = -1;
                else parent[i][j] = parent[i-1][mid];
            }
        }

    }

    int lca ( int[] depth , int[][] parent , int p , int q , int MAX ){

        if( depth[p] < depth[q] ){
            int temp = p;
            p = q;
            q = temp;
        }

        for( int i = MAX - 1 ; i >= 0 ; i-- ){
            if( parent[i][p] != -1 && depth[parent[i][p]] >= depth[q] ){
                p = parent[i][p];
            }
        }

        if(p == q) return p;

        for( int i = MAX - 1 ; i >= 0 ; i-- ){
            if( parent[i][p] != -1 && parent[i][p] != parent[i][q] ){
                p = parent[i][p];
                q = parent[i][q];
            }
        }

        return parent[0][p];
    }

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        int[] ans = new int[queries.length];

        for( int i = 0 ; i < n ; i++ ){
            adj[i] = new ArrayList<>();
        }

        for( int[] edge : edges ){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj[u].add( new int[]{ v , wt } );
            adj[v].add( new int[]{ u , wt } );
        }

        int[][] freq = new int[n][27];

        build( 0 , -1 , 0 , freq , adj );

        int[] depth = new int[n];
        final int MAX = (int)(Math.log(n)/Math.log(2)) + 1;
        int[][] parent = new int[MAX][n];

        buildParent( parent , depth , adj , MAX );
        

        for( int i = 0 ; i < queries.length ; i++ ){
            int lca = lca( depth , parent , queries[i][0] , queries[i][1] , MAX );
            System.out.println( queries[i][0] + " " + queries[i][1] + " = " + lca );
            ans[i] = solve( queries[i] , freq , lca );
        }

        return ans;
    }
}