class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;

        int arrows = 1;
        Arrays.sort( points , (a,b) -> Integer.compare( a[1] , b[1] ) );

        int lastEnd = points[0][1];

        for( int i = 1 ; i < n ; i++ ){
            if( points[i][0] > lastEnd ){
                arrows++;
                lastEnd = points[i][1];
            }
        }

        return arrows;
    }
}