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
    int cnt = 0, smallest = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return smallest;
    }

    public void dfs(TreeNode node, int k){
        if(node == null) return;
        dfs(node.left,k);
        cnt++;

        if(cnt == k){
            smallest = node.val;
            return;
        }

        dfs(node.right,k);
    }
}
