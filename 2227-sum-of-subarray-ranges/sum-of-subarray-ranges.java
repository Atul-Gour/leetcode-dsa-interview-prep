class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long maxSum = 0, minSum = 0;

        int[] left = new int[n];
        int[] right = new int[n];
        java.util.Stack<Integer> st = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            maxSum += (long)(i - left[i]) * (right[i] - i) * nums[i];
        }

        st.clear();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            minSum += (long)(i - left[i]) * (right[i] - i) * nums[i];
        }

        return maxSum - minSum;
    }
}
