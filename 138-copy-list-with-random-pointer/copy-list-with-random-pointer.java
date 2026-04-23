class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node temp = head;

        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node dummy = new Node(-1);
        Node copyTail = dummy;

        while (temp != null) {
            Node copy = temp.next;

            copyTail.next = copy;
            copyTail = copy;

            temp.next = copy.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}