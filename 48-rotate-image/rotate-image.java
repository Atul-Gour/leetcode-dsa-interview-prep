class Solution {

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            for (int i = low, j = high; i < high && j > low; i++, j--) {
                swap(matrix, low, j, i, low);
                swap(matrix, i, low, high, i);
                swap(matrix, high, i, j, high);
            }

            low++;
            high--;

        }
    }
}