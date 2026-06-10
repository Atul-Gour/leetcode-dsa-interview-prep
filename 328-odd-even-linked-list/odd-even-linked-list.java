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
    public ListNode oddEvenList(ListNode head) {

        if( head == null || head.next == null || head.next.next == null ) return head;
        
        ListNode head2 = head.next;
        ListNode head1 = head;
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        ListNode head1prev = head1;

        while( temp2 != null ){
            ListNode t = temp2.next;
            if( t != null ) temp2.next = t.next;

            temp1.next = t;

            head1prev = temp1;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if( temp1 == null ){
            temp1 = head1prev;
        }

        temp1.next = head2;

        return head1;
    }
}