class Solution {
    public ListNode sortList(ListNode left) {
        if( left == null || left.next == null ) return left;

        ListNode right = splitInTwoAndGetSecondHead( left );

        left = sortList( left );
        right = sortList( right );

        return merge( left , right );
    }
    
    private ListNode splitInTwoAndGetSecondHead( ListNode head ){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = null;
        return slow;
    }

    private ListNode merge( ListNode left , ListNode right ){

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while( left != null && right != null ){

            if( left.val < right.val ){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
            else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        while( left != null ){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while( right != null ){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return dummy.next;
    }

}