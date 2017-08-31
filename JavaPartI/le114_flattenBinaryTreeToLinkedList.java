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
/// preorder traversal
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (prev != null) {
            prev.left = null;
            prev.right = root;
        }
        prev = root;
        TreeNode right = root.right;// root.right will be changed after using flatten(root.let). left node will be conencted to the right
        flatten(root.left);
        flatten(right);
    }
}
