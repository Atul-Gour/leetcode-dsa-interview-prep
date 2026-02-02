class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a[2] ,b[2]));
        int arr[][] = new int[n][m];
        int dirs[][] = {{-1 , 0},{1 , 0},{0 , -1},{0 , 1}};

        for(int[] row : arr){
            Arrays.fill( row , Integer.MAX_VALUE );
        }

        arr[0][0] = 0;

        pq.offer( new int[]{ 0 , 0 , 0 });

        while( !pq.isEmpty() ){
            int currI = pq.peek()[0];
            int currJ = pq.peek()[1];
            int currCost = pq.peek()[2];
            pq.poll();
            if( currCost > arr[currI][currJ] )continue;
            for(int d[] : dirs){
                int newI = currI + d[0];
                int newJ = currJ + d[1];
                if( newI < n && newI >= 0 && newJ < m && newJ >= 0 ){

                    int maxDif = Math.max(arr[currI][currJ] , Math.abs(heights[newI][newJ] - heights[currI][currJ]) );
                    if( maxDif < arr[newI][newJ] ){
                        arr[newI][newJ] = maxDif;
                        pq.offer( new int[]{ newI , newJ , maxDif } );
                    }
                }
            }
        }
        return arr[n-1][m-1];
    }
}