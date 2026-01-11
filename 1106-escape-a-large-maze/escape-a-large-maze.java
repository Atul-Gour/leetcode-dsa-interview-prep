import java.util.*;

class Solution {
    private static final int LIMIT = 1_000_000;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(hash(b[0], b[1]));
        }

        int maxArea = blocked.length * (blocked.length - 1) / 2;

        return bfs(source, target, blockedSet, maxArea) &&
               bfs(target, source, blockedSet, maxArea);
    }

    private boolean bfs(int[] start, int[] end, Set<Long> blocked, int limit) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        queue.offer(start);
        visited.add(hash(start[0], start[1]));

        while (!queue.isEmpty() && visited.size() <= limit) {
            int[] cur = queue.poll();

            if (cur[0] == end[0] && cur[1] == end[1]) {
                return true;
            }

            for (int[] d : DIRS) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if (nx < 0 || ny < 0 || nx >= LIMIT || ny >= LIMIT) continue;

                long key = hash(nx, ny);
                if (blocked.contains(key) || visited.contains(key)) continue;

                visited.add(key);
                queue.offer(new int[]{nx, ny});
            }
        }

        return visited.size() > limit;
    }

    private long hash(int x, int y) {
        return ((long)x << 20) | y;
    }
}