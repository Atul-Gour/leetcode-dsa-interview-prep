class Solution {
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int i = n - 1;
        int j = m - 1;
        int index = n + m -1;

        while( i >= 0 && j >= 0 ){
            if( nums1[i] >= nums2[j] ) nums1[index--] = nums1[i--];
            else nums1[index--] = nums2[j--];
        }
        while( i >= 0 ) nums1[index--] = nums1[i--];
        while( j >= 0 ) nums1[index--] = nums2[j--];
    }
}