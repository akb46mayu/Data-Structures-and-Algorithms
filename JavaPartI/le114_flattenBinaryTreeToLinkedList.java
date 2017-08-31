/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        flat(root);
    }
    
    private TreeNode flat(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tail1 = flat(root.left);
        TreeNode tail2 = flat(root.right);
        if (tail1 != null) {
            tail1.right = root.right;
            root.right = root.left;
            root.left = null;
        } 
        if (tail2 != null) {
            return tail2;
        } 
        if (tail1 != null) {
            return tail1;
        }
        return root;
    } 
}
