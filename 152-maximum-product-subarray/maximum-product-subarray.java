class Solution {
    public int maxProduct(int[] nums) {
        long neg = 1;
        long pos = 1;

        long ans = -11;

        for( int ele : nums ){
            long tempNeg = neg;
            neg = Math.min( ele , neg*ele );
            neg = Math.min( neg , pos*ele );
            pos = Math.max( pos*ele , ele );
            pos = Math.max( pos , tempNeg*ele );

            ans = Math.max( pos , ans );
        }

        return (int)ans;
    }
}