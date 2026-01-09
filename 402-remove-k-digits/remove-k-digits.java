class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Integer> st = new Stack<>();
        int n = num.length();
        StringBuilder sb = new StringBuilder();
        int deleteCount = 0;
        
        for(int i = 0 ; i < n ; i++ ){
            char c = num.charAt(i);

            if(st.isEmpty() && c == '0'){
                continue;
            }

            while(!st.isEmpty() && deleteCount < k && st.peek() > c - '0'){
                st.pop();
                deleteCount++;
            }

            if(st.isEmpty() && c == '0'){
                continue;
            }

            st.push(c - '0');
        }

        while(!st.isEmpty() && deleteCount < k){
            st.pop();
            deleteCount++;
        }

        while(!st.isEmpty()){
            sb.append((char)(st.pop() + '0'));
        }
        if(sb.isEmpty())return "0";

        return sb.reverse().toString();
    }
}