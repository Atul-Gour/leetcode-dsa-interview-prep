class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;

        int water = 0;

        while( left <= right ){

            leftMax = Math.max( height[left] , leftMax );
            rightMax = Math.max( height[right] , rightMax );

            if( height[left] <= height[right] ){
                water += Math.max( ( Math.min( leftMax , rightMax ) - height[left]) , 0 );
                left++;
            }
            else{
                water += Math.max( ( Math.min( leftMax , rightMax ) - height[right]) , 0 );
                right--;
            }
        }

        return water;
    }
}