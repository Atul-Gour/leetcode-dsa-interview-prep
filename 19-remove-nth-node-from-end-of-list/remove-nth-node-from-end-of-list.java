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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;

        for( int i = 0 ; i < n ; i++ ){
            if( fast == null ) return null;
            fast = fast.next;
        }

        ListNode slow = head;
        ListNode prev = null;

        while( fast != null ){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if( prev == null ) return head.next;


        prev.next = prev.next.next;
        return head;
    }
}