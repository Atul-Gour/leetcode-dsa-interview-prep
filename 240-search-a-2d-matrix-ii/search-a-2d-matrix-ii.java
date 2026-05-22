class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = 0;

        // Move diagonally while current element is smaller than target
        while (row < n && col < m && matrix[row][col] < target) {
            row++;
            col++;
        }

        // Search upper rows from current col to last col
        for (int i = 0; i < Math.min(row, n); i++) {
            if (binarySearch(matrix[i], col, m - 1, target)) {
                return true;
            }
        }

        // Search remaining rows from 0 to last col
        for (int i = row; i < n; i++) {
            if (binarySearch(matrix[i], 0, m - 1, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return false;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}