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
    Map<Integer,Integer> map = new HashMap<>();
    int pre_index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if((preorder.length==1) && (1 == inorder.length)){
            return new TreeNode(preorder[0]);
        }
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(preorder,0,preorder.length-1);

    }

    public TreeNode dfs(int[] preorder, int l, int r){
        if(l>r) return null;
        int val_root = preorder[pre_index++];
        TreeNode root = new TreeNode(val_root);
        int mid = map.get(val_root);
        root.left = dfs(preorder,l,mid-1);
        root.right = dfs(preorder,mid+1,r);
        return root;
    }
}
