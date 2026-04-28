class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] nArray = new boolean[n];
        boolean[] mArray = new boolean[m];

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( matrix[i][j] == 0 ){
                    nArray[i] = true;
                    mArray[j] = true;
                }
            }
        }

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if( nArray[i] || mArray[j] ) matrix[i][j] = 0;
            }
        }

    }
}