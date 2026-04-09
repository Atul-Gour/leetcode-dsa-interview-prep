class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        int startingColor = image[sr][sc];

        if (startingColor == color) return image;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
                if (image[ni][nj] != startingColor) continue;

                image[ni][nj] = color;
                q.offer(new int[]{ni, nj});
            }
        }

        return image;
    }
}