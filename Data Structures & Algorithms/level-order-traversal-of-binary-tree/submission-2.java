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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()){
            int qSize = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < qSize; i++){
                TreeNode popped = q.poll();
                if(popped != null){
                    q.add(popped.left);
                    q.add(popped.right);
                    list.add(popped.val);
                }
            }
            if(!list.isEmpty()) res.add(list);
        }

        return res;
    }
}
