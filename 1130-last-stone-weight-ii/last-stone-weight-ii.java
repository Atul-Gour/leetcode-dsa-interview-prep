class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length ;
        int total = 0;

        for(int ele : stones) total += ele;

        int target = total/2;

        boolean[][] dp = new boolean[n][total + 1];

        dp[0][0] = true;
        dp[0][stones[0]] = true;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= total ; j++){

                if(dp[i-1][j])
                    dp[i][j] = true;
                else {
                    if(j >= stones[i])
                        dp[i][j] = dp[i-1][j - stones[i]];

                    else dp[i][j] = false;
                }
            }
        }
        int min = Integer.MIN_VALUE;
        for(int j = 0 ; j <= total ; j++){
            if(j <= target && dp[n-1][j]){
                min = Math.max( min , j);
            }
        }
        return Math.abs(total - min - min);
    }
}