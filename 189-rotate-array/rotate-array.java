class Solution {
    private void reveseArray(int[] nums, int i, int j) {
        int n = i + (j - i + 1)/2;

        for (; i < n && j >= n; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;        
        k = n - k;

        reveseArray( nums , k , n - 1 );
        reveseArray( nums , 0 , k - 1 );
        reveseArray( nums , 0 , n - 1 );

    }
}