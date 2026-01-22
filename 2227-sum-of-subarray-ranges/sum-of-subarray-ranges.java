class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        long ans = 0;

        for(int i = 0 ; i < n ; i++ ){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i] ){ 
                st.pop();
            }

            if(st.isEmpty())
                left[i] = -1;
            else
                left[i] = st.peek();
            
            st.push(i);
        }
        st.clear();
        for(int i = n-1 ; i >= 0 ; i-- ){
            while(!st.isEmpty() && nums[st.peek()] < nums[i] ){
                st.pop();
            }

            if(st.isEmpty())
                right[i] = n;
            else
                right[i] = st.peek();
            
            st.push(i);
        }



        for(int i = 0 ; i < n ; i++){
            long contri = (long)( i - left[i] )*( right[i] - i ) * nums[i];
            ans += contri;
        }

        st.clear();

        for(int i = 0 ; i < n ; i++ ){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i] ){ 
                st.pop();
            }

            if(st.isEmpty())
                left[i] = -1;
            else
                left[i] = st.peek();
            
            st.push(i);
        }
        st.clear();
        for(int i = n-1 ; i >= 0 ; i-- ){
            while(!st.isEmpty() && nums[st.peek()] > nums[i] ){
                st.pop();
            }

            if(st.isEmpty())
                right[i] = n;
            else
                right[i] = st.peek();
            
            st.push(i);
        }

        for(int i = 0 ; i < n ; i++){
            long contri = (long)( i - left[i] )*( right[i] - i ) * nums[i];
            ans -= contri;
        }
        
        return ans;

    }
}