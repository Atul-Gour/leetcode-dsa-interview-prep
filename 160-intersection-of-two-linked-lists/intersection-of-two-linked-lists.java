class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // 🔹 Loop 1: move together until one hits null or they meet
        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }

        // 🔹 If both became null → no intersection
        if (a == null && b == null) return null;

        // 🔹 Loop 2: reset the one that hit null
        if (a == null) a = headB;
        if (b == null) b = headA;
        
        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }

        // 🔹 If both became null → no intersection
        if (a == null && b == null) return null;

        // 🔹 Loop 2: reset the one that hit null
        if (a == null) a = headB;
        if (b == null) b = headA;

        // 🔹 Loop 3: now move until they meet
        while (a != b) {
            if (a == null) a = headB;
            else a = a.next;

            if (b == null) b = headA;
            else b = b.next;
        }

        return a; // intersection or null
    }
}