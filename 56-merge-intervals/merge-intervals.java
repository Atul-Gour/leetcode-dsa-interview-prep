class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort( intervals , (a , b) -> Integer.compare( a[0] , b[0] ) );
        ArrayList<int[]> list = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while( i < intervals.length ){
            int start = intervals[i][0];
            int end = intervals[i][1];

            while( i + 1 < n && intervals[i + 1][0] <= end ){
                i++;
                end = Math.max( intervals[i][1] , end );
            }

            list.add( new int[]{start , end} );
            i++;
        }

        int[][] ans = new int[ list.size() ][2];

        for( i = 0 ; i < list.size() ; i++ ){
            ans[i] = list.get(i);
        }

        return ans;
    }
}