class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if( nums1.length > nums2.length )  return findMedianSortedArrays( nums2 , nums1 );

        int n = nums1.length, m = nums2.length;
        int total = m + n ;
        

        int low = 0;
        int high = n;
        int left = (n + m + 1)/2;
        int l1 = 0 , l2 = 0 , r1 = 0 , r2 = 0;

        while( low <= high ){
            int mid1 = low + (high - low)/2;
            l1 = mid1 - 1 < 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            r1 = mid1 >= n ? Integer.MAX_VALUE : nums1[mid1];

            int mid2 = left - mid1;
            l2 = mid2 - 1 < 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            r2 = mid2 >= m ? Integer.MAX_VALUE : nums2[mid2];


            if( l1 <= r2 && l2 <= r1 ) break;
            else if( l1 > r2 ) high = mid1 - 1;
            else low = mid1 + 1;
        }
        
        double ans ;

        if( total % 2 == 0 )
            ans = (Math.max(l1 , l2) + Math.min( r1 , r2 )) / 2.0;
        else
            ans = Math.max( l1 , l2 );

        return ans;
    }
}
