class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
    }
}
class MedianFinder {
    Node head;
    int n=0;
    Node middle;

    public MedianFinder() {
        head= null;
        middle = head;
    }

    void add(Node newNode){
        Node temp = head;
        Boolean isMiddle = false;
        if(newNode.val >= middle.val){
            temp=middle;
            isMiddle = true;
        }

        while(temp.next != null && newNode.val>temp.next.val){
            temp=temp.next;
        }
        newNode.next= temp.next;
        newNode.prev= temp;
        temp.next = newNode;
        if(newNode.next!=null)newNode.next.prev = newNode;
        if(isMiddle){
            if(n%2==0)middle= middle.next;
        }else{
            if(n%2==0)return;
            middle= middle.prev;
        }

    }
    
    public void addNum(int num) {
        Node newNode = new Node(num);

        if (head == null) {
            newNode.next = head;
            head = newNode;
            middle=head;
            n++;
            return;
        }else if(num< head.val){
            newNode.next = head;
            head.prev = newNode;
            head= newNode;
            if(n%2!=0)middle = middle.prev;
            n++;
            return;
        }
        else {
            add(newNode);
            n++;
        }
    }
    
    public double findMedian() {
        double median =0;
        if(n%2!=0){
            median = middle.val;
        }else{
            
            int a= middle.val;
            int b= middle.next.val;
            median = (b+a)/2.0;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */