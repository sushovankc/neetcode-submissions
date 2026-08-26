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
    public List<Integer> rightSideView(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
       List<Integer> res = new ArrayList<>();

       if(root == null) return res;

       q.add(root);

       while(!q.isEmpty()){
        int qSize = q.size();

        for(int i = 0; i < qSize; i++){
            TreeNode node = q.poll();
            if(i == qSize - 1 && node != null){
                res.add(node.val);
            }
            if(node.left != null){
                q.add(node.left);
            }

            if(node.right != null){
                q.add(node.right);
            }
        }
       } 
       return res;
    }
}
