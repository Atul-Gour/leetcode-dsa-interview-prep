class Solution {
    public int findMinArrowShots(int[][] points) {

        int n = points.length;
        if(n == 1) return 1;

        Arrays.sort(points , (a,b)->{
            if(a[0] != b[0]) 
                return Integer.compare(a[0] , b[0]);
            else return Integer.compare(a[1] , b[1]);
        });

        int end = points[0][1];
        int deleted = 0;

        for(int i = 1 ; i < n ; i++){
            if(points[i][0] <= end){
                deleted++;
                end = Math.min(end , points[i][1]);
            }else{
                end = points[i][1];
            }
        }
        return n - deleted;
    }
}