class Solution {
    private ListNode reverse( ListNode head ){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while( curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if( head.next == null ) return;

        ListNode fast = head;
        ListNode prev = null;
        ListNode slow = head;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        if( fast != null ){
            prev = slow;
            slow = slow.next;
            prev.next = null;
        }
        else prev.next = null;

        ListNode second = reverse(slow);
        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }
}