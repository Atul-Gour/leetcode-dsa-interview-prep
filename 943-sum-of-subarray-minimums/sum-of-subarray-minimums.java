class Solution {
    public int sumSubarrayMins(int[] arr) {
        long MOD = 1_000_000_007L;
        Stack<int[]> st = new Stack<>();
        int n = arr.length;
        long ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && st.peek()[0] >= arr[i] ){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = st.peek()[1];
            }

            st.push( new int[]{arr[i] , i} );
        }
        st.clear();

        for(int i = n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && st.peek()[0] > arr[i] ){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n;
            }
            else{
                right[i] = st.peek()[1];
            }

            st.push( new int[]{arr[i] , i} );
        }

        for(int i = n - 1 ; i >= 0 ; i--){

            int leftCount  = i - left[i];
            int rightCount = right[i] - i;
            ans = (ans + (long) arr[i] * leftCount * rightCount) % MOD;
        }

        return (int)ans;
    }
}