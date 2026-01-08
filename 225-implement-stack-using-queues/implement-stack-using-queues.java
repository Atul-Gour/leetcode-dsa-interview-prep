class MyStack {
    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();
        int ele =-1;
        while(!q1.isEmpty()){
            if(q1.size() == 1){ 
                ele = q1.poll();
                break;
            }
            q2.offer(q1.poll());
        }
        
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return ele;
    }
    
    public int top() {
        Queue<Integer> q2 = new LinkedList<>();
        int ele = -1;
        while(!q1.isEmpty()){
            if(q1.size() == 1) ele = q1.peek();
            q2.offer(q1.poll());
        }
        
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return ele;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */