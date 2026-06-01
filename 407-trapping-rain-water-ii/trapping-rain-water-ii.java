class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        if( n < 3 || m < 3 ) return 0;

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>( (int[] a , int[] b) -> Integer.compare( heightMap[a[0]][a[1]] , heightMap[b[0]][b[1]] ) );
        int[][] dirs = { { 0 , 1 } , {0 , -1} , {-1 , 0} , {1 , 0} };
 
        int water = 0;
        int minHeight = 0;

        for( int j = 0 ; j < m ; j++ ){ pq.offer( new int[]{0 , j} ); visited[0][j] = true; }
        for( int j = 0 ; j < m ; j++ ){ pq.offer( new int[]{n-1 , j} ); visited[n-1][j] = true; }
        for( int i = 1 ; i < n-1 ; i++ ){ pq.offer( new int[]{i , 0} ); visited[i][0] = true; }
        for( int i = 1 ; i < n-1 ; i++ ){ pq.offer( new int[]{i , m-1} ); visited[i][m-1] = true; }

        while( !pq.isEmpty() ){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];

            minHeight = Math.max( minHeight , heightMap[x][y] );
            water += Math.max( 0 , minHeight - heightMap[x][y] );

            for( int[] d : dirs ){
                int newX = x + d[0];
                int newY = y + d[1];

                if( newX < 0 || newY < 0 || newX >= n || newY >= m || visited[newX][newY] ) continue;

                visited[newX][newY] = true;
                pq.offer( new int[]{newX , newY} );
            }
        }

        return water;
    }
}