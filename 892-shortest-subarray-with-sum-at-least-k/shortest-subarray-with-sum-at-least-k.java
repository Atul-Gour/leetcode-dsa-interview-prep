class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        long[] prefix = new long[n+1];

        for( int i = 0 ; i < n ; i++ ) prefix[i+1] = prefix[i] + nums[i];

        ArrayDeque< Integer > q = new ArrayDeque<>();

        for( int i = 0 ; i <= n ; i++ ){
            while( !q.isEmpty() &&  prefix[i] - prefix[q.peekFirst()] >= k ){
                ans = Math.min(ans , i - q.pollFirst() );
            }

            while( !q.isEmpty() && prefix[q.peekLast()] >= prefix[i] ){
                q.pollLast();
            }

            q.addLast(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}