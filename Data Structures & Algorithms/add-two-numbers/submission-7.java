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
        int carry = 0;

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(head1 != null || head2 != null || carry != 0){
            int sum = carry;
            if(head1 != null){
                sum += head1.val;
                head1 = head1.next;
            }
            
            if(head2 != null){
                sum += head2.val;
                head2 = head2.next;
            }

            cur.next = new ListNode(sum % 10);
            carry = sum / 10;

            cur = cur.next;
            // if(head1 != null) head1 = head1.next;
            // if(head2 != null) head2 = head2.next;
        }

        return res.next;
    }

}
