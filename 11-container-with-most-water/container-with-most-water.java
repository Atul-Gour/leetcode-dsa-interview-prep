class Solution {
    public int maxArea(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;

        int water = 0;

        while( left <= right ){

            leftMax = Math.max( height[left] , leftMax );
            rightMax = Math.max( height[right] , rightMax );

            int currWater = Math.min(leftMax , rightMax)*(right - left);
            water = Math.max( currWater , water );

            if( height[left] <= height[right] )left++;
            else right--;
        }

        return water;
    }
}