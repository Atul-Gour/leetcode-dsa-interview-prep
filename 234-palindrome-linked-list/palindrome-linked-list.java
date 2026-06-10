/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        boolean odd = false;
        if( fast.next == null ) odd = true;

        ListNode head2 = slow.next;
        slow.next = null;

        ListNode head1 = reverse(head);

        if( odd ) head1 = head1.next;

        while( head1 != null && head2 != null ){
            if( head1.val != head2 .val ) return false;
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }
}