class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if( m < n ) return findMedianSortedArrays( nums2 , nums1 );

        int left = ( n + m + 1 )/2;

        int low = 0;
        int high = n;

        while( low <= high ){
            int mid = low + (high - low)/2 ; 
            
            int l1 = mid - 1 >= 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int r1 = mid < n ? nums1[mid] : Integer.MAX_VALUE;

            int l2 = left - mid - 1 >= 0 ? nums2[left - mid - 1] : Integer.MIN_VALUE;
            int r2 = left - mid < m ? nums2[left - mid] : Integer.MAX_VALUE;

            if( l1 > r2 ) high = mid - 1;
            else if( l2 > r1 ) low = mid + 1;
            else{
                if( (n + m) % 2 == 0 ){
                    return ( Math.max( l1 , l2 ) + Math.min( r1 , r2 ) ) / 2.0 ;
                }
                else return  (double)Math.max( l1 , l2 );
            }

        }

        return 1.0;
    }
}