class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int[][] dist = new int[n][m];

        for (int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);

        q.offer(new int[] { 0, 0, 0 });
        dist[0][0] = 0;

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];

            if (i == n-1 && j == m-1) return dist[i][j];

            for (int[] d : dirs) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m ) continue;

                int newDist = Math.max( dist[i][j] , Math.abs( heights[i][j] - heights[ni][nj] ) );

                if( dist[ni][nj] > newDist ){
                    dist[ni][nj] = newDist;
                    q.offer(new int[] { ni, nj , newDist });
                }
            }

        }

        return -1;
    }
}