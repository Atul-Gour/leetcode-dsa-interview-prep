class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOne = 0;
        int maxOneIndex = 0;

        for( int i = 0 ; i < mat.length ; i++ ){
            int currOne = 0;
            for( int j = 0 ; j < mat[0].length ; j++ ) if( mat[i][j] == 1 ) currOne++;

            if( currOne > maxOne ){
                maxOne = currOne;
                maxOneIndex = i;
            } 
        }

        return new int[]{maxOneIndex , maxOne};
    }
}