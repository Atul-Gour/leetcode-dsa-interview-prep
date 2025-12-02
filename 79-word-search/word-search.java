class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        char[] w = word.toCharArray(); // avoid repeated charAt()
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, w, 0, i, j)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int index, int i, int j) {
        if (index == word.length) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != word[index]) return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited in-place (no extra visited[][] array)

        boolean found = dfs(board, word, index + 1, i + 1, j)
                     || dfs(board, word, index + 1, i - 1, j)
                     || dfs(board, word, index + 1, i, j + 1)
                     || dfs(board, word, index + 1, i, j - 1);

        board[i][j] = temp; // unmark (backtrack)
        return found;
    }
}
