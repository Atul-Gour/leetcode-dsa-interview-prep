class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while( temp != null ){
            size++;
            temp = temp.next;
        }

        if( n == size ) return head.next;

        temp = head;
        for( int i = 0 ; i < size-n ; i++ ){
            if( i == size-n-1 ){
                temp.next = temp.next.next;
                return head;
            }

            temp = temp.next;
        }

        return head;
    }
}