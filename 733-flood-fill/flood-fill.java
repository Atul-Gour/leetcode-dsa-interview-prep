class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int startingColor = image[sr][sc];

        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };



        q.offer(new int[] { sr, sc });
        image[sr][sc] = color;
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];

            for (int[] dir : dirs) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI >= n || newI < 0 || newJ >= m || newJ < 0 || image[newI][newJ] != startingColor || visited[newI][newJ] )
                    continue;
                
                visited[newI][newJ] = true;
                image[newI][newJ] = color;
                q.offer(new int[] { newI, newJ });
            }
        }

        return image;

    }
}