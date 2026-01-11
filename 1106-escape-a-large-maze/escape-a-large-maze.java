class Solution {
    static final int LIMIT = 1_000_000;
    static final int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};
    Set<Long> blocked = new HashSet<>();

    long encode(int x, int y) {
        return ((long)x << 20) | y;
    }

    public boolean isEscapePossible(int[][] blockedCells, int[] source, int[] target) {
        for (int[] b : blockedCells) {
            blocked.add(encode(b[0], b[1]));
        }

        int max = blockedCells.length * blockedCells.length;

        return bfs(source, target, max) && bfs(target, source, max);
    }

    boolean bfs(int[] start, int[] end, int max) {
        Set<Long> vis = new HashSet<>();
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.add(start);
        vis.add(encode(start[0], start[1]));

        int count = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) return true;
            if (++count > max) return true;

            for (int[] d : DIR) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if (nx < 0 || ny < 0 || nx >= LIMIT || ny >= LIMIT) continue;

                long key = encode(nx, ny);
                if (blocked.contains(key) || vis.contains(key)) continue;

                vis.add(key);
                q.add(new int[]{nx, ny});
            }
        }
        return false;
    }
}
