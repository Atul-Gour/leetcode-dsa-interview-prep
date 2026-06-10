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

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;

        if( slow.next == null ) return;

        while( fast != null && fast.next != null ){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode head2 = reverse( slow );

        ListNode temp = head;

        while( head2 != null ){
            temp = head.next;
            head.next = head2;
            head = temp;
            temp = head2.next;

            if( head == null ){
                break;
            }
            else{
                head2.next = head;
                head2 = temp;
            }
            
        }


    }
}