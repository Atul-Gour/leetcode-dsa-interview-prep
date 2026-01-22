class Node {
    int val;
    int killed;

    Node(int value, int kill) {
        this.val = value;
        this.killed = kill;
    }
}

class StockSpanner {

    Stack<Node> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int kill = 1;

        while( !st.isEmpty() && st.peek().val <= price ){
            kill += st.pop().killed;
        }

        st.push( new Node( price , kill ) );

        return kill;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */