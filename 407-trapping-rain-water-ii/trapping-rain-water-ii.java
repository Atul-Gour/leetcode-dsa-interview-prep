class Solution {

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        if(n <= 2 || m <= 2) return 0;

        boolean[][] visited = new boolean[n][m];

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[2] - b[2]);

        for(int i=0;i<n;i++){
            pq.offer(new int[]{i,0,heightMap[i][0]});
            pq.offer(new int[]{i,m-1,heightMap[i][m-1]});
            visited[i][0] = true;
            visited[i][m-1] = true;
        }

        for(int j=1;j<m-1;j++){
            pq.offer(new int[]{0,j,heightMap[0][j]});
            pq.offer(new int[]{n-1,j,heightMap[n-1][j]});
            visited[0][j] = true;
            visited[n-1][j] = true;
        }

        int water = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int h = curr[2];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr<0 || nc<0 || nr>=n || nc>=m || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;

                if(heightMap[nr][nc] < h){
                    water += h - heightMap[nr][nc];
                }

                pq.offer(new int[]{
                    nr,
                    nc,
                    Math.max(h , heightMap[nr][nc])
                });
            }
        }

        return water;
    }
}
