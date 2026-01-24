class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1)return 0;

        int[] dp = new int[n];

        Arrays.fill( dp ,Integer.MAX_VALUE );

        dp[0] = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if( j > i && dp[i] != Integer.MAX_VALUE && nums[i] >= j - i )
                    dp[j] = Math.min( dp[j] , dp[i] + 1 );
                else
                   break;
            }
        }
        return dp[n-1];
    }
}