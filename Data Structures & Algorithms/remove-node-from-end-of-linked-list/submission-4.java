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
        int numberOfNodes = 0;

        ListNode temp = head;

        while(temp != null){
            temp = temp.next;
            numberOfNodes++;
        }

        if(numberOfNodes - n == 0) return head.next;

        ListNode cur = head;

        int curNode = 1;
        while(cur != null){
            if(curNode == numberOfNodes - n){
                cur.next = cur.next.next;
                break;
            }

            cur = cur.next;
            curNode++;
        }

        return head;
    }
}
