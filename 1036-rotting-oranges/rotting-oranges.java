class Solution {

    private void bfs(int arr[], int minutes[][], int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean visited[][] = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(arr);

        int time = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr[] = q.poll();
                minutes[curr[0]][curr[1]] = Math.min( minutes[curr[0]][curr[1]] , time );
                visited[curr[0]][curr[1]] = true;

                for (int[] d : dirs) {
                    int newI = curr[0] + d[0];
                    int newJ = curr[1] + d[1];
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && !visited[newI][newJ] && grid[newI][newJ] == 1 && minutes[newI][newJ] > time + 1 ) {
                        q.offer(new int[] { newI, newJ });
                    }
                }
            }

            time++;
        }

    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        ArrayList<int[]> rottenList = new ArrayList<>();
        int minutes[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    rottenList.add(new int[] { i, j });
                }
                if( grid[i][j] != 0 )
                    minutes[i][j] = Integer.MAX_VALUE;
            }
        }


        for (int[] arr : rottenList) {
            bfs(arr, minutes , grid);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( grid[i][j] == 1 ){
                    if( minutes[i][j] == Integer.MAX_VALUE ) return -1;

                    ans = Math.max( ans , minutes[i][j] );
                }
            }
        }

        return ans;
    }
}