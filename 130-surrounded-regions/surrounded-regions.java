class Solution {
    private void bfs(int x, int y, boolean visited[][], char[][] board) {

        int n = board.length;
        int m = board[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        q.add(new int[] { x, y });
        visited[x][y] = true;
        boolean surrounded = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                list.add(new int[] { curr[0], curr[1] });

                for (int d[] : dirs) {
                    int newI = curr[0] + d[0];
                    int newJ = curr[1] + d[1];
                    if (newI < n && newI >= 0 && newJ < m && newJ >= 0 && board[newI][newJ] == 'O'
                            && !visited[newI][newJ]) {
                        if (newI == n - 1 || newJ == m - 1 || newI == 0 || newJ == 0)
                            surrounded = false;

                        visited[newI][newJ] = true;
                        q.add(new int[] { newI, newJ });
                    }
                }
            }
        }

        if (surrounded) {
            for (int[] cell : list) {
                board[cell[0]][cell[1]] = 'X';
            }
        }

    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 'O' && i != n - 1 && j != m - 1 && i != 0 && j != 0) {
                    bfs(i, j, visited, board);
                }
            }
        }
    }
}