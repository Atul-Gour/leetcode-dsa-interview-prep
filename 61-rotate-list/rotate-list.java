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

    private ListNode reverse( ListNode curr ){
        ListNode prev = null;
        ListNode next = null;

        while( curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if( k == 0 || head == null || head.next == null ) return head;
        
        int length = 0;
        ListNode temp = head;

        while( temp != null ){ length++; temp = temp.next; }

        k %= length;
        if (k == 0) return head;

        temp = head;
        for( int i = 1 ; i < length - k ; i++ ){
            temp = temp.next;
        }

        ListNode head2 = reverse(temp.next);
        temp.next = null;
        ListNode head1 = reverse(head);

        head.next = head2;

        return reverse( head1 );
    }
}