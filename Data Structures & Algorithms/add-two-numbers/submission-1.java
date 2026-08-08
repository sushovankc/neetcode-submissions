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
        int num1 = 0, num2 = 0;
        ListNode cur1 = l1, cur2 = l2;
        String fnum = "";
        String snum = "";

        while(cur1 != null){
            fnum = cur1.val + fnum;
            cur1 = cur1.next;
        }
        while(cur2 != null){
            snum = cur2.val + snum;
            cur2 = cur2.next;
        }
        
        num1 = Integer.parseInt(fnum);
        num2 = Integer.parseInt(snum);
        int sum = num1+num2;
        String sumString = sum+"";

        ListNode last = null;
        for(char s: sumString.toCharArray()){
            ListNode node = new ListNode(Integer.parseInt(String.valueOf(s)));
            node.next = last;
            last = node;            
        }

        return last;
    }
}