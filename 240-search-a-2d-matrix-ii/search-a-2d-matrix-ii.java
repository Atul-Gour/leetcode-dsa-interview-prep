class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = Math.min(n, m) - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[mid][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int boundary = l;

        for (int i = 0; i < boundary; i++) {
            if (binarySearch(matrix[i], boundary, m - 1, target)) {
                return true;
            }
        }

        for (int i = boundary; i < n; i++) {
            if (binarySearch(matrix[i], 0, m - 1, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}