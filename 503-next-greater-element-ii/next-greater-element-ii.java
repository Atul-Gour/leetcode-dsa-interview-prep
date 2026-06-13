class Solution {
    public int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int n = nums.length;

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }

        for (int i = n - 1 ; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return ans;
    }
}