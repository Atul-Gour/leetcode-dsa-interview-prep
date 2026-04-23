class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node , Node> map = new HashMap<>();

        Node temp = head;
        Node dummy = new Node(-1);

        while( temp != null ){
            Node newNode = new Node( temp.val );
            map.put( temp , newNode );
            dummy.next = newNode;
            dummy = dummy.next;
            temp = temp.next;
        }

        temp = head;

        while( temp != null ){
            
            if( temp.random != null ){
                Node correspondingNode = map.get( temp );
                correspondingNode.random = map.get( temp.random );
            }

            temp = temp.next;
            
        }

        return map.get(head);
    }
}