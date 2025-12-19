class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i: arr) sum+=i;
        if(sum % 2 != 0)return false;

        sum /= 2;
        if(arr[0]>sum)return false;
        boolean dp[][] = new boolean[n][ sum + 1 ];

        dp[0][0] = true;
        dp[0][arr[0]] = true;

        for(int i = 1 ; i < n ;i++){
            for(int j = 0 ; j <= sum ; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;

                if(arr[i]<=j){
                    take = dp[i-1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n-1][sum];
    }
}