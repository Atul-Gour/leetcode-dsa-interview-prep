class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        if(n == 1 && m == 1)return 0;
        if(grid[0][0] == 1)k--;

        Queue<int[]> q = new ArrayDeque<>();

        int arr[][][] = new int[k + 1][n][m];

        for(int ar[][]: arr){
            for(int a[] : ar){
                Arrays.fill( a , Integer.MAX_VALUE );
            }
        }

        int[][] dirs = { {1,0} , {-1,0} , {0,1} , {0,-1} };
        

        q.offer( new int[]{ 0 , 0 , 0 , k } );
        arr[k][0][0] = 0;

        while( !q.isEmpty() ){
            int curr[] = q.poll();
            int currI = curr[0];
            int currJ = curr[1];
            int currSteps = curr[2];
            int currK = curr[3];

            if(currI == n-1 && currJ == m-1)return currSteps;
            if( arr[currK][currI][currJ] < currSteps )continue;

            for( int d[] : dirs ){
                int newI = currI + d[0];
                int newJ = currJ + d[1];
                int newK = currK;
                if(newI < n && newI >= 0 && newJ < m && newJ >= 0){
                    
                    if( (grid[newI][newJ] == 1 && currK <= 0) )continue;
                    if( grid[newI][newJ] == 1)newK--;
                    if( arr[newK][newI][newJ] <= currSteps + 1 ) continue;
                    if(newI == n-1 && newJ == m-1)return currSteps + 1;

                    arr[newK][newI][newJ] = currSteps + 1;
                    q.offer( new int[]{ newI , newJ , currSteps + 1 , newK } );

                }
            }
        }
        return -1;
    }
}