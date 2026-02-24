class Solution {
    public int minTimeToReach(int[][] moveTime) {

        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][][] dist = new int[n][m][2];

        for (int[][] grid : dist)
            for (int[] row : grid)
                Arrays.fill(row, Integer.MAX_VALUE);

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{0,0,0,0});

        dist[0][0][0] = 0;

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int time = curr[0];
            int x = curr[1];
            int y = curr[2];
            int parity = curr[3];

            if(x == n-1 && y == m-1)
                return time;

            if(time > dist[x][y][parity]) continue;

            for(int[] d : dirs) {

                int nx = x + d[0];
                int ny = y + d[1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                int moveCost = (parity == 0) ? 1 : 2;

                int newTime = Math.max(time, moveTime[nx][ny]) + moveCost;

                int newParity = 1 - parity;

                if(newTime < dist[nx][ny][newParity]) {

                    dist[nx][ny][newParity] = newTime;

                    pq.offer(new int[]{newTime, nx, ny, newParity});
                }
            }
        }

        return -1;
    }
}