class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int i = 0; 
        int j = 0;
        Arrays.sort(intervals , (a ,b)-> a[0] - b[0] );

        ArrayList<int[]> list = new ArrayList<>();

        while(i < n){
            j = i ;
            int start = intervals[i][0];
            int end = intervals[i][1];

            while( j + 1 < n && intervals[j + 1][0] <= end ){
                end = Math.max( end , intervals[j + 1][1] );
                j++;
            }

            i = j + 1;

            list.add( new int[]{ start , end } );
            
        }

        int ans[][] = new int[list.size()][2];

        for( i = 0 ; i < list.size() ; i++ ){
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}