class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length ;
        if(n == 1)return stones[0];
        int total = 0;

        for(int ele : stones) total += ele;

        int target = total/2;

        boolean[][] dp = new boolean[n][target + 1];

        dp[0][0] = true;
        dp[0][stones[0]] = true;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= target ; j++){

                if(dp[i-1][j])
                    dp[i][j] = true;
                else {
                    if(j >= stones[i])
                        dp[i][j] = dp[i-1][j - stones[i]];

                    else dp[i][j] = false;
                }
            }
        }
        for(int j = target ; j >= 0 ; j--){
            if(dp[n-1][j]){
                return Math.abs(total - j - j);
            }
        }
        return 0;
    }
}