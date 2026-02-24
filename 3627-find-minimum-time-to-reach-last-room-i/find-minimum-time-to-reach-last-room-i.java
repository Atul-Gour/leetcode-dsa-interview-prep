class Solution {
    public int minTimeToReach(int[][] moveTime) {

        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{0,0,0});

        dist[0][0] = 0;

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int time = curr[0];
            int x = curr[1];
            int y = curr[2];

            if(x == n-1 && y == m-1)
                return time;

            if(time > dist[x][y]) continue;

            for(int[] d : dirs) {

                int nx = x + d[0];
                int ny = y + d[1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                int newTime = Math.max(time, moveTime[nx][ny]) + 1;

                if(newTime < dist[nx][ny]) {

                    dist[nx][ny] = newTime;

                    pq.offer(new int[]{newTime, nx, ny});
                }
            }
        }

        return -1;
    }
}