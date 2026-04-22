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

        if( fast != null ){
            slow = slow.next;
        }

        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        while( secondHalf != null ){
            if( secondHalf.val != firstHalf.val ) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;

    }
}