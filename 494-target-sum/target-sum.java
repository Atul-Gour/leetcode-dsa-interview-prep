class Solution {
    private int solve( int index , int curr , int target , int nums[] , HashMap<String , Integer> memo ){

        int n = nums.length;

        if ( index == n ){
            if( curr == target ) return 1;
            else return 0;
        }

        String key = index + "," + curr;

        if( memo.containsKey(key) ) return memo.get(key);

        int total = 0;

        total += solve( index + 1 , curr + nums[index] , target , nums , memo );
        total += solve( index + 1 , curr - nums[index] , target , nums , memo );

        memo.put( key , total );

        return total; 

    }

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        HashMap<String , Integer> memo = new HashMap<>();

        return solve( 0 , 0 , target , nums , memo );

    }
}