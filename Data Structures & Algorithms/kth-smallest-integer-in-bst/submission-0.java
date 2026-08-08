/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int n = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        findNum(root,k);
        return n;
    }

    public void findNum(TreeNode root, int k){
        if(root == null){
            return;
        }
        findNum(root.left, k);
        count++;

        if(count == k){
            n = root.val;
            return;
        }
        
        findNum(root.right, k);

    }
}
