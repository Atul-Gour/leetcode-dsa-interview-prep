/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    private ListNode find(ListNode slow, ListNode head) {
        ListNode fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // or fast (both same)
    }


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow ) return find( slow , head );
        }

        return null;
    }
}