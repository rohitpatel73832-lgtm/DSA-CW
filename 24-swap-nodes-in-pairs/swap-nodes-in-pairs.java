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
    public ListNode swapPairs(ListNode head) {
        ListNode temp=head;
        ListNode a;
        ListNode b;
        if(head==null) return null;
        if(head.next==null) return head;
        while(temp!=null && temp.next!=null){
            a =temp.next;
            b=temp;
            int t=b.val;
            b.val = a.val;
            a.val = t;

            temp = temp.next.next;


            
        }
        return head;
    }
}