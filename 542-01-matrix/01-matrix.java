class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        ArrayDeque< int[] > q = new ArrayDeque<>();

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( mat[i][j] == 0  ) q.offer( new int[]{ i , j } );
                else ans[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dirs = { {0 , 1} , {1 , 0} , {-1 , 0} ,{0 , -1}};
        int dist = 1;

        while( !q.isEmpty() ){
            int size = q.size();
            
            while( size-- > 0 ){
                int curr[] = q.poll();
                int i = curr[0];
                int j = curr[1];

                for( int[] d : dirs ){
                    int newI = i + d[0];
                    int newJ = j + d[1];

                    if( newI < 0 || newJ < 0 || newI >= n || newJ >= m )continue;
                    if( ans[newI][newJ] <= dist )continue;

                    ans[newI][newJ] = dist;
                    q.offer( new int[]{ newI , newJ } );
                }
            }
            
            dist++;
        }

        return ans;

    }
}