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

        for (int i = 0; i < pos - 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return head;
    }
    
}
