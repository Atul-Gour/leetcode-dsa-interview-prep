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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode temp= head;
        int remainder=0;

        while(l1!=null && l2!=null){
            int curr= l1.val + l2.val + remainder;
            if(curr>9){
                remainder=curr/10;
                curr= curr-10;
            }else{
                remainder=0;
            }
            System.out.println(curr+" "+remainder);
            ListNode newNode= new ListNode(curr);
            temp.next= newNode;
            temp=temp.next;
            l1= l1.next;
            l2=l2.next;
        }
        while(l1!=null){
           int curr= l1.val + remainder;
            if(curr>9){
                remainder=curr/10;
                curr= curr-10;
            }else{
                remainder=0;
            }
            System.out.println(curr+" "+remainder);
            ListNode newNode= new ListNode(curr);
            temp.next= newNode;
            temp=temp.next;
            l1= l1.next;
        }
        while(l2!=null){
            int curr= l2.val + remainder;
            if(curr>9){
                remainder=curr/10;
                curr= curr-10;
            }else{
                remainder=0;
            }
            System.out.println(curr+" "+remainder);
            ListNode newNode= new ListNode(curr);
            temp.next= newNode;
            temp=temp.next;
            l2= l2.next;
        }
        if(remainder>0){
            ListNode newNode= new ListNode(remainder);
            temp.next= newNode;
        }
        return head.next;
    }
}