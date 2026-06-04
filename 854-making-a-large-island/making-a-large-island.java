class DSU{
    int[] parent ;
    int[] size ;

    DSU( int n ){
        this.parent = new int[n];
        this.size = new int[n];

        for( int  i = 0 ; i < n ; i++ ) parent[i] = i;
        Arrays.fill( size , 1 );
    }

    int find( int ele ){
        if( parent[ele] == ele ) return ele;

        return parent[ele] = find( parent[ele] );
    }

    boolean union( int a , int b ){
        int pa = find( a );
        int pb = find( b );

        if( pa == pb ) return false;

        int sizeA = size[pa];
        int sizeB = size[pb];

        if( sizeA < sizeB ){
            parent[pa] = pb;
            size[pb] += sizeA;
        }
        else{
            parent[pb] = pa;
            size[pa] += sizeB;
        }

        return true;
    }

    int size( int ele ){
        int parent = find( ele );
        return size[parent];
    }

}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        int[][] dirs = {{0,1} , {0,-1} , {1,0} , {-1,0}};
        DSU dsu = new DSU( n * m );

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                
                if( grid[i][j] == 0 ) continue;

                for( int[] dir : dirs ){
                    int newX = i + dir[0];
                    int newY = j + dir[1];

                    if( newX < 0 || newY < 0 || newX >= n || newY >= m || grid[newX][newY] == 0 ) continue;

                    dsu.union( i*m + j  , newX*m + newY );
                }

            }
        }

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                
                if( grid[i][j] == 1 ){
                    ans = Math.max( ans , dsu.size( i*m + j ) );
                    continue;
                }

                int currAns = 0;
                HashSet<Integer> set = new HashSet<>();

                for( int[] dir : dirs ){
                    int newX = i + dir[0];
                    int newY = j + dir[1];

                    if( newX < 0 || newY < 0 || newX >= n || newY >= m || grid[newX][newY] == 0 ) continue;

                    set.add( dsu.find( newX*m + newY ) );
                }

                for( int ele : set ){
                    currAns += dsu.size( ele ); 
                }
                
                ans = Math.max( ans , currAns + 1 );
            }
        }

        return ans;
    }
}












