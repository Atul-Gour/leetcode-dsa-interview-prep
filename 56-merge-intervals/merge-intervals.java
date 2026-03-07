class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort( intervals , (a , b) -> {
            if( a[0] != b[0] ) return a[0] - b[0];
            else return b[1] - a[1];
        });

        for( int i = 0 ; i < n ; i++ ){
            int start = intervals[i][0];
            int end = intervals[i][1];

            while( i + 1 < n && intervals[i + 1][0] <= end ){
                end = Math.max(end , intervals[i + 1][1]);
                i++;
            }

            list.add( new int[]{ start , end });
        }

        return list.toArray( new int[list.size()][2] );
    }
}