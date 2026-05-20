class Solution {

    private boolean possibleSplit(int[] nums , int k , long maxSum ){
        int parts = 1;
        long currSum = 0;

        for( int ele : nums ){
            if( currSum + ele > maxSum ){
                parts++;
                currSum = ele;
            }
            else currSum += ele;
        }

        return parts <= k;
    }

    public int splitArray(int[] nums, int k) {
        // if( k > nums.length ) return -1;

        long sum = 0;
        long max = 0;

        for( int ele : nums ){
            sum += ele;
            max = Math.max( ele , max );
        }

        long l = max;
        long r = sum;

        while( l < r ){
            long mid = l + ( r - l )/2;
            if( possibleSplit( nums , k , mid ) ) r = mid;
            else l = mid + 1;
        }

        return (int)l;
    }
}