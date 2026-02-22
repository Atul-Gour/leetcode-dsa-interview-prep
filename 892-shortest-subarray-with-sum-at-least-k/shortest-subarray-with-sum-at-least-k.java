class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        long[] prefix = new long[n+1];

        for( int i = 0 ; i < n ; i++ ){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = Integer.MAX_VALUE;

        for( int i = 0 ; i < n + 1 ; i++ ){
            while( !queue.isEmpty() && prefix[queue.peekLast()] >= prefix[i] ){
                queue.removeLast();
            }

            queue.addLast(i);
            
            while( prefix[i] - prefix[queue.peekFirst()] >= k ){
                ans = Math.min( ans , i - queue.removeFirst() );
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}