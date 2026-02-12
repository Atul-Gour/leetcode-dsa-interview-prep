class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;
        long prefix[] = new long[n + 1];

        for( int i = 0 ; i < n ; i++ ){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for( int i = 0 ; i <= n ; i++ ){

            long target = prefix[i] - k;

            while( !deque.isEmpty() && target >= prefix[deque.peekFirst()] ){
                ans = Math.min( ans , i - deque.pollFirst() );
            }

            while( !deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()] ){
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }
}