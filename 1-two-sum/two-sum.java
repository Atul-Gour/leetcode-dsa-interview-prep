class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        int[][] arr = new int[n][2];

        for( int i = 0 ; i < n ; i++ ){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort( arr , ( a , b ) -> Integer.compare( a[0] , b[0] ) );
        int l = 0;
        int r = n-1;

        while( l < r ){
            long sum = (long)arr[l][0] + arr[r][0];

            if( sum == target ) return new int[]{arr[l][1] , arr[r][1]};
            else if( sum < target )l++;
            else r--;
        }

        return new int[]{};
    }
}