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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr=head;
        ListNode prev=null;
        ListNode temp=head;
        int count=0;
        if(head==null) return null;
        if(head.next==null) return head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        
         k=k%count;
         if(k==0) return head;
        count =count-k;
        
        for(int i=0; i<count; i++){
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        ListNode tail=curr;
        while(tail.next!=null){
            tail=tail.next;
            

        }
        tail.next=head;
        return curr;
    }
}