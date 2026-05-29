class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;

        int[] dp = new int[n];

        for( int index = n-2 ; index >= 0 ; index-- ){

            int ans = Integer.MAX_VALUE;

            for( int i = 1 ; i <= nums[index] ; i++ ){
                int j = i + index;
                if( j >= n ) break;

                int curr = dp[j];
                if( curr != Integer.MAX_VALUE ) curr++;

                ans = Math.min( ans , curr );
            }

            dp[index] = ans;
        }

        return dp[0];
    }
}