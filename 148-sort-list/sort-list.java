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
    private ListNode divide( ListNode head ){
        if( head == null || head.next == null ) return head;

        ListNode slow = head;
        ListNode fast = head;

        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode first = head;
        ListNode second = slow.next;

        slow.next = null;

        first = divide( first );
        second = divide( second );
        return merge( first , second );
    }

    private ListNode merge( ListNode first , ListNode second ){
        ListNode tempHead = new ListNode( -1 );
        ListNode temp = tempHead;
        
        while( first != null && second != null ){
            if( first.val <= second.val ){
                temp.next = first;
                first = first.next;
                temp = temp.next;
                temp.next = null;
            }
            else{
                temp.next = second;
                second = second.next;
                temp = temp.next;
                temp.next = null;
            }
        }

        while( first != null ){
            temp.next = first;
            first = first.next;
            temp = temp.next;
            temp.next = null;
        }

        while( second != null ){
            temp.next = second;
            second = second.next;
            temp = temp.next;
            temp.next = null;
        }

        return tempHead.next;
    }

    public ListNode sortList(ListNode head) {
        return divide(head);
    }
}