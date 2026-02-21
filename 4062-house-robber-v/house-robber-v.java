class Solution {
    public long rob(int[] nums, int[] color) {
        int n = nums.length;
        long arr[] = new long[n+1];

        arr[n - 1] = nums[n-1];  

        for( int i = n - 2 ; i >= 0 ; i-- ){
            if( color[i] == color[i + 1] ){
                arr[i] = Math.max( nums[i] + arr[ i + 2 ] , arr[i + 1] );
            }
            else{
                arr[i] = nums[i] + arr[i + 1];
            }
        }

        return arr[0];
    }
}