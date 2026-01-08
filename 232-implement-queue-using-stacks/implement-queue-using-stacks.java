class MyQueue {

    Stack<Integer> st;

    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        Stack<Integer> stTemp = new Stack<>();
        int ele = -1;
        while(!st.isEmpty()){
            if(st.size() == 1){
                ele = st.pop();
                break;
            }
            stTemp.push(st.pop());
        }
        while(!stTemp.isEmpty()){
            st.push(stTemp.pop());
        }
        return ele;
    }
    
    public int peek() {
        Stack<Integer> stTemp = new Stack<>();
        int ele = -1;
        while(!st.isEmpty()){
            if(st.size() == 1){
                ele = st.peek();
            }
            stTemp.push(st.pop());
        }
        while(!stTemp.isEmpty()){
            st.push(stTemp.pop());
        }
        return ele;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */