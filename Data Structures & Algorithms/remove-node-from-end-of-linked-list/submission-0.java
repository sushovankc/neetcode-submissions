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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode cur = head;

        int len = 0;

        while(cur != null){
            cur = cur.next;
            len++;
        }

        if (n == len) {
            return head.next;
        }

        int pos = len - n;
        System.out.println(len);
        len = 0;

        cur = head;

        while(pos>1){
            cur = cur.next;
            pos--;
        }

        cur.next = cur.next.next;

        return head;
    }
    
}
