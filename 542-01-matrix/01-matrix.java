class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = {{-1 , 0} , {1 , 0} , {0 , -1} , {0 , 1}};

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if( mat[i][j] == 1 )
                    mat[i][j] = Integer.MAX_VALUE;
                else{
                    q.offer( new int[]{i , j});
                    visited[i][j] = true;
                }
            }
        }
        int time = 0;
        while( !q.isEmpty() ){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                int[] curr = q.poll();
                mat[curr[0]][curr[1]] = time;

                for( int d[] : dirs){
                    int newI = curr[0] + d[0];
                    int newJ = curr[1] + d[1];
                    if( newI >= 0 && newI < n && newJ >= 0 && newJ < m && !visited[newI][newJ] && mat[newI][newJ] == Integer.MAX_VALUE ){
                        visited[newI][newJ] = true;
                        q.offer( new int[]{ newI , newJ });
                    }
                }
            }
            time++;
        }
        return mat;
    }
}