import java.util.*;

class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> st = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ',') continue;

            if (ch != ')') {
                st.push(ch);
            } 
            else {
                int t = 0, f = 0;

                // pop till '('
                while (st.peek() != '(') {
                    char val = st.pop();
                    if (val == 't') t++;
                    else f++;
                }

                st.pop(); // remove '('

                char op = st.pop(); // operator

                char res;

                if (op == '&') {
                    res = (f == 0) ? 't' : 'f';
                } 
                else if (op == '|') {
                    res = (t > 0) ? 't' : 'f';
                } 
                else { // '!'
                    res = (t == 1) ? 'f' : 't';
                }

                st.push(res);
            }
        }

        return st.peek() == 't';
    }
}