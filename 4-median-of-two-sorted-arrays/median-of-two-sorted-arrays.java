class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // Always binary search on the smaller array
        if (n < m) return findMedianSortedArrays(nums2, nums1);

        int total = n + m;
        int half = (total + 1) / 2;

        // ✅ Only base case needed: if smaller array is empty
        if (m == 0) {
            if (total % 2 == 0)
                return (nums1[half - 1] + nums1[half]) / 2.0;
            else
                return nums1[half - 1];
        }

        int l = 0;
        int r = half;

        int l1 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE;
        int l2 = Integer.MIN_VALUE, r2 = Integer.MAX_VALUE;

        while (l <= r) {
            // mid = how many elements we take from nums1
            // Clamp to valid range [0, n] and [0, m]
            int mid = Math.min(l + (r - l) / 2, n); // ✅ can't take more than n from nums1
            int mid2 = half - mid;                   // how many we take from nums2

            // ✅ Clamp mid2 to valid range
            if (mid2 < 0) { r = mid - 1; continue; }
            if (mid2 > m) { l = mid + 1; continue; }

            l1 = mid  > 0 ? nums1[mid  - 1] : Integer.MIN_VALUE;
            r1 = mid  < n ? nums1[mid]       : Integer.MAX_VALUE;
            l2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            r2 = mid2 < m ? nums2[mid2]      : Integer.MAX_VALUE;

            if (l1 > r2) {
                r = mid - 1;       // too far right in nums1
            } else if (l2 > r1) {
                l = mid + 1;       // too far left in nums1
            } else {
                break;             // valid partition
            }
        }

        if (total % 2 == 0)
            return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        else
            return Math.max(l1, l2);
    }
}