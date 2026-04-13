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
        ArrayList<Integer> ans= new ArrayList<>();
        ListNode temp= head;
        while(temp!=null){
            ans.add(temp.val);
            temp=temp.next;
        }
        ListNode head1= new ListNode(0);
        ListNode t = head1;
        //ListNode t= head;
        Collections.sort(ans);
        for(int i=0; i<ans.size(); i++){
            ListNode a = new ListNode(ans.get(i));
            t.next=a;
            t=a;
        }
        return head1.next;
    }
}