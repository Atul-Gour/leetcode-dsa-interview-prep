class Solution {
    public int maxProduct(int[] nums) {
        int product = 1;
        int negativeProduct = 1;
        int ans = Integer.MIN_VALUE;

        for( int ele : nums ){
            product *= ele;
            negativeProduct *= ele;

            int originalProduct = product;
            product = Math.max( negativeProduct , product );
            negativeProduct = Math.min( negativeProduct , Math.min(originalProduct , ele) );

            if( product < ele ) product = ele;
            if( negativeProduct == 0 ) negativeProduct = ele;

            ans = Math.max( ans , product );
            ans = Math.max( ans , negativeProduct );

        }

        return ans;
    }
}