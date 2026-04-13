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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        //String s="";
        StringBuilder sb = new StringBuilder("");
        while(temp!=null){
            sb.append(temp.val);
            temp=temp.next;
        }
        String bin= sb.toString();
        int ans = Integer.parseInt(bin, 2);
        return ans;
    }
}