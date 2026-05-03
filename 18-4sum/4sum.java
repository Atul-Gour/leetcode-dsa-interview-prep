class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort( nums );

        for( int i = 0 ; i < n - 3 ; i++ ){

            if( i > 0 && nums[i - 1] == nums[i] ) continue;

            for( int j = i + 1 ; j < n - 2 ; j++ ){
                
                if( j > i + 1 && nums[j - 1] == nums[j] ) continue;

                int l = j + 1;
                int r = n - 1;

                while( l < r ){
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];

                    if( sum == target ){
                        ans.add( new ArrayList<>( List.of( nums[i] , nums[j] , nums[l] , nums[r] )));

                        while( l + 1 < n && nums[l] == nums[l + 1] ) l++;
                        while( r - 1 > j && nums[r - 1] == nums[r] ) r--;

                        l++;
                        r--;
                    }
                    else if( sum < target ) l++;
                    else r--;
                }                
            }
        }

        return ans;
    }
}