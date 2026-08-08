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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }

        ListNode res = lists[0];  
        int n = lists.length;

        for(int i = 1;i<n;i++){
            res = mergeTwoLists(res,lists[i]);
        }

        return res;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b){

        ListNode dum = new ListNode(0);
        ListNode node = dum;

        while(a != null && b != null){

            if(a.val < b.val){
                node.next = a;
                a = a.next;
            }else{
                node.next = b;
                b = b.next;
            }
            node = node.next;
        }

        if( a != null){
            node.next = a;
        }else{
            node.next = b;
        }

        return dum.next;
    }
}
