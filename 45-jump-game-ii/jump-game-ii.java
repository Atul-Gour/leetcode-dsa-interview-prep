class Solution {

    private int solve( int index , int[] dp , int[] nums ){
        int n = nums.length;

        if( index == n-1 ) return 0;
        if( dp[index] != -1 ) return dp[index];

        int ans = Integer.MAX_VALUE;

        for( int i = 1 ; i <= nums[index] ; i++ ){
            int j = i + index;
            if( j >= n ) break;

            int curr = solve(j , dp , nums);
            if( curr != Integer.MAX_VALUE ) curr++;

            ans = Math.min( ans , curr );
        }

        return dp[index] = ans;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;

        for( int ele : nums ) maxJump = Math.max( ele , maxJump );

        int[] dp = new int[n];

        Arrays.fill(dp , -1);

        int ans = solve( 0 , dp , nums );

        return ans;
    }
}