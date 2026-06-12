class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort( nums );
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for( int i = 0 ; i < n - 2 ; i++ ){

            if( i > 0 && nums[i - 1] == nums[i] ) continue;

            int left = i + 1;
            int right = n - 1;

            while( left < right ){
                int sum = nums[i] + nums[left] + nums[right];

                if( sum == 0 ){
                    ans.add( new ArrayList<>( List.of( nums[i] , nums[left] , nums[right] ) ) );
                    while( left + 1 < right && nums[left + 1] == nums[left] ) left++;

                    left++;
                    right--;
                }
                else if( sum < 0 ) left++;
                else right--;
            }
        }

        return ans;
    }
}