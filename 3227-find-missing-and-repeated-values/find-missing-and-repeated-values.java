class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length * grid.length ;
        long squareExpectedSum = ( (long)n * ( n + 1 ) * ( 2*n + 1 ) ) / 6 ;
        long expectedSum = ((long)n * (n + 1)) / 2;
        long squareActualSum = 0 ;
        long actualSum = 0;

        for( int arr[] : grid ){
            for( int ele : arr ){
                actualSum += ele;
                squareActualSum += ele*ele;
            }
        }

        long x = expectedSum - actualSum;
        long y = (squareExpectedSum - squareActualSum) / x;

        long a = ( x + y ) / 2 ;
        long b = y - a;

        return new int[]{ (int)b , (int)a };

    }
}