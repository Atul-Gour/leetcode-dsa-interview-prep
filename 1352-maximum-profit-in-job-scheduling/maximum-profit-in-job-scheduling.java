class Solution {
    int[] memo;
    int findNext(int[][] jobs, int currentEnd, int start) {
        int low = start, high = jobs.length - 1, next = jobs.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][0] >= currentEnd) {
                next = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return next;
    }
    int calculateMaxProfix(int[][] jobs,int time,int index){
        if(index>=jobs.length )return 0;
        if(jobs[index][0]<time)return calculateMaxProfix(jobs, time, index+1);
        if(memo[index]!=-1)return memo[index];
        int notIncludedProfit = calculateMaxProfix(jobs, time, index+1);
        int nextIndex = findNext(jobs, jobs[index][1], index + 1);
        int includedProfit = jobs[index][2] + calculateMaxProfix(jobs, jobs[index][1], nextIndex);
        return memo[index]=Math.max(notIncludedProfit, includedProfit);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        memo= new int[n];
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.fill(memo,-1);
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        return (int)calculateMaxProfix(jobs, 0, 0);
    }
}