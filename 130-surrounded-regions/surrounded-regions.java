class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') bfs(i, 0, board);
            if (board[i][m-1] == 'O') bfs(i, m-1, board);
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') bfs(0, j, board);
            if (board[n-1][j] == 'O') bfs(n-1, j, board);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void bfs(int x, int y, char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        board[x][y] = '#';

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length && board[ni][nj] == 'O') {
                    board[ni][nj] = '#';
                    q.add(new int[]{ni, nj});
                }
            }
        }
    }
}
