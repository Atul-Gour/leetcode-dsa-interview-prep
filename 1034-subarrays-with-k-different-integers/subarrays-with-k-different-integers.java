class Solution {

    private int count( int[] nums, int k ){

        HashMap<Integer , Integer> map = new HashMap<>();

        int l = 0;
        int total = 0;

        for( int r = 0 ; r < nums.length ; r++ ){

            map.put( nums[r] , map.getOrDefault( nums[r] , 0 ) + 1 );

            while( map.size() > k ){
                map.put( nums[l], map.get(nums[l]) - 1 );
                if( map.get(nums[l]) == 0 ) map.remove( nums[l] );
                l++;
            }

            total += r - l + 1; 

        }

        return total;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count( nums , k ) - count( nums , k - 1 );
    }
}