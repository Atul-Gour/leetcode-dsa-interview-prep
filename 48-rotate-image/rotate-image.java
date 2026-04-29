class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int x1 = 0;
        int y1 = 0;
        int x2 = n-1;
        int y2 = n-1;
        int[] temp = new int[n];

        while( x1 <= x2 ){
            
            for( int j = y1 , i = 0 ; i <= x2 - x1 && j <= y2 ; i++ , j++ ){
                temp[i] = matrix[x1][j];
            }

            for( int i = x1 , j = y2 ; i <= x2 && j >= y1 ; i++ , j-- ){
                matrix[x1][j] = matrix[i][y1];
            }

            for( int i = x1 , j = y1 ; i <= x2 && j <= y2 ; i++ , j++ ){
                matrix[i][y1] = matrix[x2][j];
            }

            for( int i = x2 , j = y1 ; i >= x1 && j <= y2 ; i-- , j++ ){
                matrix[x2][j] = matrix[i][y2];
            }

            for( int i = x1 , j = 0 ; i <= x2 && j <= y2-y1 ; i++ , j++ ){
                matrix[i][y2] = temp[j];
            }

            x1++;
            y1++;
            x2--;
            y2--;

        }
    }
}