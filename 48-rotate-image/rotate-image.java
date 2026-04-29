class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int low = 0;
        int high = n-1;
        int[] temp = new int[n];

        while( low <= high ){
            
            for( int j = low , i = 0 ; i <= high - low && j <= high ; i++ , j++ ){
                temp[i] = matrix[low][j];
            }

            for( int i = low , j = high ; i <= high && j >= low ; i++ , j-- ){
                matrix[low][j] = matrix[i][low];
            }

            for( int i = low , j = low ; i <= high && j <= high ; i++ , j++ ){
                matrix[i][low] = matrix[high][j];
            }

            for( int i = high , j = low ; i >= low && j <= high ; i-- , j++ ){
                matrix[high][j] = matrix[i][high];
            }

            for( int i = low , j = 0 ; i <= high && j <= high-low ; i++ , j++ ){
                matrix[i][high] = temp[j];
            }

            low++;
            high--;

        }
    }
}