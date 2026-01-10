class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int size = n + m;
        boolean isEven = false;

        if(size % 2 == 0){
            size = size/2 + 1;
            isEven = true;
        }else{
            size = size/2 + 1;
        }

        double[] arr = new double[size];
        int idx1 = 0, idx2 = 0;
        int x = 0;

        while ((x < size) && (idx1 < m) && (idx2 < n)) {
            if (nums1[idx1] < nums2[idx2]) {
                arr[x++] = nums1[idx1++];
            } else {
                arr[x++] = nums2[idx2++];
            }
        }

        while ( (x < size) && (idx1 < m)) {
            arr[x++] = nums1[idx1++];
        }

        while ((x < size) && (idx2 < n)) {
            arr[x++] = nums2[idx2++];
        }

        if (isEven) {
            return (arr[size - 1] + arr[size - 2]) / 2;
        } else {
            return (arr[size - 1]);
        }
    }
}