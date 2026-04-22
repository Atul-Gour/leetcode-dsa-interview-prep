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
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a,b) -> Integer.compare( a.val , b.val ) );

        while( head != null ){
            pq.offer( head );
            head = head.next;
        }

        ListNode newHead = pq.poll();
        ListNode temp = newHead;

        while( !pq.isEmpty() ){
            temp.next = pq.poll();
            temp = temp.next;
            temp.next = null;
        }

        return newHead;
    }
}