class Solution {

    int[][] dirs = { {0,-1}, {0,1}, {-1,0}, {1,0} };

    int[][][] streetDirs = {
        {},
        { {0,-1}, {0,1} },        // 1 → left, right
        { {-1,0}, {1,0} },        // 2 → up, down
        { {0,-1}, {1,0} },        // 3 → left, down
        { {0,1}, {1,0} },         // 4 → right, down
        { {-1,0}, {0,-1} },       // 5 → up, left
        { {-1,0}, {0,1} }         // 6 → up, right
    };

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];

            if(i == n-1 && j == m-1) return true;

            for(int[] d : streetDirs[grid[i][j]]){
                int ni = i + d[0];
                int nj = j + d[1];

                if(ni < 0 || nj < 0 || ni >= n || nj >= m || vis[ni][nj]) continue;

                for(int[] back : streetDirs[grid[ni][nj]]){
                    if(ni + back[0] == i && nj + back[1] == j){
                        vis[ni][nj] = true;
                        q.offer(new int[]{ni,nj});
                        break;
                    }
                }
            }
        }
        return false;
    }
}