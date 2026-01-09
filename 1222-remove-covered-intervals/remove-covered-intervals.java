class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a , b)-> {
            if(a[0] != b[0]) return a[0]-b[0];
            else return b[1] -a[1];
        });
        int n = intervals.length;
        if(n == 1)return 1;

        int deleted = 0;
        int end = intervals[0][1];

        for(int i = 1 ; i < n ; i++){
            if(intervals[i][1] <= end){
                deleted++;
            }else{
                end = intervals[i][1];
            }
        }
        return n - deleted;
    }
}