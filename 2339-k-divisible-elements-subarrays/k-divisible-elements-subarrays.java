class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        int l = 0;
        int divisibleCount = 0;
        ArrayDeque<Integer> list = new ArrayDeque<>();

        for( int i = 0 ; i < n ; i++ ){
            divisibleCount = 0;
            list = new ArrayDeque<>();

            for(int j = i ; j < n ; j++){

                if( nums[j] % p == 0 ) divisibleCount++;
                list.addLast(nums[j]);

                if( divisibleCount > k )break;

                set.add( new ArrayList<>(list) );

            }
        }
        return set.size();
    }
}