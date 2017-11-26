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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symHelper(root.left, root.right);
    }
    
    private boolean symHelper(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else {
            if (one.val != two.val) {
                return false;
            }
            return symHelper(one.left, two.right) && symHelper(one.right, two.left);
        }
        
    }
}
