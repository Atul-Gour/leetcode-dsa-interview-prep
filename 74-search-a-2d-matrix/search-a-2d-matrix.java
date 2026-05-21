class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 1;
        int r = n * m;

        while( l <= r ){
            int mid = l + ( r - l )/2;

            int mr = (mid + m - 1)/ m - 1;
            int mc = (mid - 1) % m;
            System.out.println( mid + " " + mr + " " + mc );

            if( matrix[mr][mc] == target ) return true;
            else if( matrix[mr][mc] < target ){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return false;
    }
}