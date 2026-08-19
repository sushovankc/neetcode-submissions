/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;
        Node temp = head;

        while(temp != null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;

            temp = copy.next;
        }

        temp = head;

        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next; // temp.next = copy node = temp.random.next
            }

            temp = temp.next.next;
        }

        temp = head;
        Node copyHead = head.next;
        Node copy = copyHead;

        while(temp != null){

            temp.next = temp.next.next;

            if(copy.next != null){
                copy.next = copy.next.next;
            }

            temp = temp.next;
            copy = copy.next;          
        }

        return copyHead;

    }
}
