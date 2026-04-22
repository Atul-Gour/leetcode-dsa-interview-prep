/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0;
        int m = 0;

        ListNode temp = headA;
        while( temp != null ){
            n++;
            temp = temp.next;
        }

        temp = headB;
        while( temp != null ){
            m++;
            temp = temp.next;
        }
        
        if( m < n ){
            temp = headA;
            headA = headB;
            headB = temp;

            int t = n;
            n = m;
            m = t;
        }



        for( int i = 0 ; i < m - n ; i++ ){
            headB = headB.next;
        }

        while( headA != null ){
            if( headA == headB ) return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}