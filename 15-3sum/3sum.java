class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort( nums );

        for( int i = 0 ; i < n - 2 ; i++ ){

            if( i > 0 && nums[i - 1] == nums[i] ) continue;
            int l = i + 1;
            int r = n - 1;

            while( l < r ){

                int sum = nums[i] + nums[l] + nums[r];

                if( sum == 0 ){
                    ans.add( new ArrayList<>( List.of( nums[i] , nums[l] , nums[r] ) ) );

                    while( l + 1 < n && nums[l] == nums[l + 1] ) l++;
                    while( r - 1 >= 0 && nums[r - 1] == nums[r] ) r--;
                    l++;
                    r--;
                }
                else if( sum < 0 ) l++;
                else r--;
            }
        }
        
        return ans;

    }
}