class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Stack<Integer> st = new Stack<>();

        int[] leftGreater = new int[n];
        for( int i = 0 ; i < n ; i++ ){
            while( !st.isEmpty() && nums[st.peek()] < nums[i] ) st.pop();
            leftGreater[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        int[] rightGreater = new int[n];
        for( int i = n-1 ; i >= 0 ; i-- ){
            while( !st.isEmpty() && nums[st.peek()] <= nums[i] ) st.pop();
            rightGreater[i] = st.empty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        int[] leftSmaller = new int[n];
        for( int i = 0 ; i < n ; i++ ){
            while( !st.isEmpty() && nums[st.peek()] > nums[i] ) st.pop();
            leftSmaller[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        int[] rightSmaller = new int[n];
        for( int i = n-1 ; i >= 0 ; i-- ){
            while( !st.isEmpty() && nums[st.peek()] >= nums[i] ) st.pop();
            rightSmaller[i] = st.empty() ? n : st.peek();
            st.push(i);
        }

        for( int i = 0 ; i < n ; i++ ){
            long smallerContri = (long)( i - leftSmaller[i] )*( rightSmaller[i] - i );
            long greaterContri = (long)( i - leftGreater[i] )*( rightGreater[i] - i );
            ans += ( nums[i] * greaterContri ) - ( nums[i] * smallerContri );
        }

        return ans;
    }
}