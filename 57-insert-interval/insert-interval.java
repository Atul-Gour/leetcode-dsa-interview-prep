class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList< int[] > list = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        int n = intervals.length;
        boolean put = false;

        for( ; i < n ; i++ ){
            if( intervals[i][1] < start ){
                list.add( intervals[i] );
            }
            else{
                if( intervals[i][0] <= end ){
                    start = Math.min( intervals[i][0] , newInterval[0] );
                    end = Math.max( intervals[i][1] , newInterval[1] );
                }
                break;
            }
        }

        for( ; i < n && !put ; i++ ){
            if( intervals[i][0] <= end ){
                end = Math.max( intervals[i][1] , end );
            }else break;
        }

        list.add( new int[]{ start , end });

        for( ; i < n ; i++ ){
            list.add( intervals[i] );
        }

        int[][] ans = new int[list.size()][2];
        int index = 0;

        for( int[] a : list ){
            ans[index][0] = a[0];
            ans[index][1] = a[1];
            index++;
        }

        return ans;
    }
}