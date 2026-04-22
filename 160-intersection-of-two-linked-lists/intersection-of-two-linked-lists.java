class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }

        if (a == null && b == null) return null;

        if (a == null) a = headB;
        if (b == null) b = headA;
        
        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }

        if (a == null && b == null) return null;

        if (a == null) a = headB;
        if (b == null) b = headA;

        while (a != b) {
            if (a == null) a = headB;
            else a = a.next;

            if (b == null) b = headA;
            else b = b.next;
        }

        return a;
    }
}