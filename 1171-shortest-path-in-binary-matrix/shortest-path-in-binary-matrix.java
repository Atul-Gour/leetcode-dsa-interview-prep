class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)return -1;

        int[][] arr = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a , b) -> Integer.compare(a[2] , b[2]));
        pq.offer(new int[]{ 0 , 0 , 1 });

        for(int a[] : arr){
            Arrays.fill(a , -1);
        }
        arr[0][0] = 1;

        while( !pq.isEmpty() ){
            int currI = pq.peek()[0];
            int currJ = pq.peek()[1];
            int currCost = pq.peek()[2];
            pq.poll();

            for( int i = -1 ; i <= 1 ; i++){
                for(int j = -1 ; j <= 1 ; j++){
                    if (i == 0 && j == 0) continue;
                    int newI = currI + i;
                    int newJ = currJ + j;
                    if( newI < n && newI >= 0 && newJ < m && newJ >= 0 && grid[newI][newJ] == 0 && arr[newI][newJ] == -1 ){
                        arr[newI][newJ] = currCost + 1;
                        if( newI == n-1 && newJ == m-1 )return arr[newI][newJ];
                        pq.offer(new int[]{ newI , newJ , arr[newI][newJ] });
                    }
                }
            }
        }
        return arr[n-1][m-1];
    }
}