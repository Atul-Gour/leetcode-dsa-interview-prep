class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dirs[][] = {{0,0} , {0,1} , {0,-1} , {1,0} , {-1,0}};
        int cost[][] = new int[n][m];

        for(int row[] : cost){
            Arrays.fill( row , Integer.MAX_VALUE );
        }
        cost[0][0] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer( new int[]{ 0, 0});

        while( !q.isEmpty() ){
            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];
            for( int d = 1 ; d <= 4 ; d++){
                int newI = i + dirs[d][0];
                int newJ = j + dirs[d][1];

                if(newI >= n || newI < 0 || newJ >= m || newJ < 0)continue;
                int newCost = 1 + cost[i][j];
                if(d == grid[i][j]) newCost--;


                if( newCost < cost[newI][newJ] ){
                    cost[newI][newJ] = newCost;
                    q.add( new int[]{ newI , newJ } );
                }
            }
        }
        return cost[n-1][m-1];
    }
}