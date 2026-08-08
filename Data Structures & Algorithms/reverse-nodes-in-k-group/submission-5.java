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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1){
            return head;
        }

        ListNode dum = new ListNode(0);
        ListNode prevTail = dum;
        ListNode cur = head;

        while(true){
            ListNode[] arr = reverseList(cur, k);

            if(arr[1] == cur){
                break;
            }

            prevTail.next = arr[1]; // New head of Reversed Portion
            cur.next = arr[0]; // Head of next portion

            prevTail = cur;
            cur = cur.next;
            
        }

        return dum.next;
        
    }

    public ListNode[] reverseList(ListNode list, int k){

        ListNode check = list;

        for(int i = 0;i<k;i++){
            if(check == null){
                return new ListNode[]{list,list};
            }
            check = check.next;
        }

        ListNode cur = list;
        ListNode prev = null;

        while(k > 0){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            k--;            
        }

        // Return NextHead, NewHeadOfReversedLL
        return new ListNode[]{cur,prev};
    
    }
}
