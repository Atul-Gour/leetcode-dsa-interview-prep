class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int iEnd = matrix.length - 1;
        int jEnd = matrix[0].length - 1;

        int iStart = 0;
        int jStart = 0;

        List<Integer> ans = new ArrayList<>();
        
        while( iStart <= iEnd && jStart <= jEnd ){
            for( int j = jStart ; j <= jEnd && iStart <= iEnd ; j++ ) ans.add( matrix[iStart][j] );
            iStart++;

            for( int i = iStart ; i <= iEnd && jStart <= jEnd ; i++ ) ans.add( matrix[i][jEnd] );
            jEnd--;

            for( int j = jEnd ; j >= jStart && iStart <= iEnd ; j-- ) ans.add( matrix[iEnd][j] );
            iEnd--;

            for( int i = iEnd ; i >= iStart && jStart <= jEnd ; i-- ) ans.add( matrix[i][jStart] );
            jStart++;
        }

        return ans;
    }
}