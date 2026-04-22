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

        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        ListNode temp = new ListNode(-1);

        while( secondHalf != null || firstHalf != null ){

            if( firstHalf != null ){
                temp.next = firstHalf;
                temp = temp.next;
                firstHalf = firstHalf.next;
            }

            if( secondHalf != null ){
                temp.next = secondHalf;
                temp = temp.next;
                secondHalf = secondHalf.next;
            }

        }

    }
}