class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;

        int[] nums = new int[n + 1];
        for( int i = 0 ; i < n ; i++ ){
            nums[i+1] = nums[i] + (hours[i] > 8 ? 1 : -1) ;
        }

        Deque<Integer> st = new ArrayDeque<>();

        for( int i = 0 ; i <= n ; i++ ){
            if( !st.isEmpty() && nums[st.peek()] <= nums[i] )continue;
            st.push(i);
        }

        int maxLen = 0;
        for( int i = n ; i >= 0 ; i-- ){
            while( !st.isEmpty() && nums[st.peek()] < nums[i] ){
                maxLen = Math.max( maxLen , ( i - st.pop())) ;
            }
        }

        return maxLen;
    }
}