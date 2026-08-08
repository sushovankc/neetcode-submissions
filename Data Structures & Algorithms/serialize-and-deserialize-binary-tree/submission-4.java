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

public class Codec {
    String serialized = "";
    int preOrder = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return serialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return dfsDeserialize(values);
    }

    public void dfsSerialize(TreeNode root){
        if(root == null){
            serialized += "N,";
            return;
        }

        serialized += root.val+",";
        dfsSerialize(root.left);
        dfsSerialize(root.right);
    }

    public TreeNode dfsDeserialize(String[] data){

        String node_val = data[preOrder++];
        if(node_val.equals("N")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node_val));

        root.left = dfsDeserialize(data);
        root.right = dfsDeserialize(data);

        return root;
    }
}
