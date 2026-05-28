class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int ans = 0;

        for( int i = 0 ; i < s.length() ; i++ ){
            char ch = s.charAt(i);

            if( ch == ')' && st.peek() != -1  && s.charAt(st.peek()) == '(' ) st.pop();
            else st.push(i);

            ans = Math.max( ans , i - st.peek() );
        }

        return ans;
    }
}