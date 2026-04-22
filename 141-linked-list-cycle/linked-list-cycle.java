public class Solution {
    public boolean hasCycle(ListNode fast) {
        ListNode slow = fast;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow ) return true;
        }

        return false;
    }
}