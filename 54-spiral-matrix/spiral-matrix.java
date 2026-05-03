class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int xEnd = matrix.length - 1;
        int yEnd = matrix[0].length - 1;

        int xStart = 0;
        int yStart = 0;

        while( xStart <= xEnd && yStart <= yEnd ){

            for( int j = yStart ; j <= yEnd && xStart <= xEnd ; j++ ){
                ans.add( matrix[xStart][j] );
            }
            xStart++;

            for( int i = xStart ; i <= xEnd && yStart <= yEnd ; i++ ){
                ans.add( matrix[i][yEnd] );
            }
            yEnd--;

            for( int j = yEnd ; j >= yStart && xStart <= xEnd ; j-- ){
                ans.add( matrix[xEnd][j] );
            }
            xEnd--;

            for( int i = xEnd ; i >= xStart && yStart <= yEnd ; i-- ){
                ans.add( matrix[i][yStart] );
            }
            yStart++;  

        }

        return ans;
    }
}