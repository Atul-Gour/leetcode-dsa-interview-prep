class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            ans = Math.max(ans, maxRectangle(heights));
        }

        return ans;
    }

    private int maxRectangle(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : nums[i];

            while (!st.isEmpty() && nums[st.peek()] > h) {
                int height = nums[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();
                int width = right - left - 1;

                max = Math.max(max, height * width);
            }

            st.push(i);
        }

        return max;
    }
}