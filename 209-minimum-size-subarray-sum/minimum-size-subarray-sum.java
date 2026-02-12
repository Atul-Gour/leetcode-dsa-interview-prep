class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            long target = prefix[i] - k;
            
            while( !deque.isEmpty() && target >= prefix[ deque.peekFirst() ] ){
                ans = Math.min(ans, i - deque.pollFirst() );
            }

            while( !deque.isEmpty() && prefix[i] <= prefix[ deque.peekLast() ] ){
                deque.pollLast();
            }

            deque.addLast( i );
        }

        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}