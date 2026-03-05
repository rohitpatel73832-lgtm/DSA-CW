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
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode temp1=l1;
//         ListNode temp2=l2;
//         ListNode self=new ListNode(100);
//         ListNode temp3=self;
//         int st=0;
//         while(l1!=null || l2!=null){
//             st=temp1.val+temp2.val;
//             if(st>=10){
//                 int digit = st % 10;
//                 carry = st / 10;

//                 temp3.next=st+carry;
//                 temp1=temp1.next;
//                 temp2=temp2.next;
//                 temp3=temp3.next;
//             }
//             temp3.next=temp1.val+temp2.val;
//             temp1=temp1.next;
//             temp2=temp2.next;
//             temp3=temp3.next;


//         }
//         return self.next;

//     }
// }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode self = new ListNode(0);
        ListNode temp3 = self;

        int st = 0;
        int carry = 0;

        while (temp1 != null || temp2 != null) {

            st = carry;

            if (temp1 != null) {
                st += temp1.val;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                st += temp2.val;
                temp2 = temp2.next;
            }

            carry = st / 10;
            temp3.next = new ListNode(st % 10);
            temp3 = temp3.next;
        }

        if (carry > 0) {
            temp3.next = new ListNode(carry);
        }

        return self.next;
    }
}
           