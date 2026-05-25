class Solution {

    private int find(int x, int y, int[] nums, int k) {
        int ops = 0;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int rem = ((a % k) + k) % k;
            int target = (i % 2 == 0) ? x : y;

            int downCost = (rem - target + k) % k;
            int upCost = (target - rem + k) % k;

            ops += Math.min(downCost, upCost);
        }

        return ops;
    } 

    public int minOperations(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;

        for( int i = 0 ; i < k ; i++ ){
            for( int j = 0 ; j < k ; j++ ){
                if( i == j ) continue;
                int currStep = find( i , j , nums , k );
                ans = Math.min( ans , currStep );
            }
        }

        return ans;
    }
}