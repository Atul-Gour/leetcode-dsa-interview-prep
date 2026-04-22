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

        if( head.next == null ) return true;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = null;

        if( fast == null ){
            fast = slow;
        }
        else{
            fast = slow.next;
        }

        slow = reverse( head );

        while( slow != null && fast != null ){
            if( slow.val != fast.val ) return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;

    }
}