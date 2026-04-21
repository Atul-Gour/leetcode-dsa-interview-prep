class NumArray {
    long[] prefix;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.prefix = new long[n + 1];

        for(int i = 1 ; i <= n ; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        return (int) (prefix[right + 1] - prefix[left]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */