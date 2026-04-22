class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        
        HashMap<Integer , ListNode> map = new HashMap<>();
        map.put(0 , head);

        while( temp != null ){

            size++;
            map.put( size , temp );

            if( temp.next == null ){
                if( n == size ) return head.next;
                else if( map.containsKey( size - n ) ){
                    ListNode node = map.get( size - n );
                    node.next = node.next.next;
                    return head;
                }
            }

            temp = temp.next;
        }

        return head;
    }
}