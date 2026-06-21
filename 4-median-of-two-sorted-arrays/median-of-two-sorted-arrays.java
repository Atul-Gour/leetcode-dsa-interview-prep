class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLeft = (n + m + 1) / 2;

        int low = 0;
        int high = n;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = totalLeft - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];

            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 > r2) {
                high = cut1 - 1;
            } else if (l2 > r1) {
                low = cut1 + 1;
            } else {

                if ((n + m) % 2 == 1) {
                    return Math.max(l1, l2);
                }

                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
        }

        return 0.0;
    }
}