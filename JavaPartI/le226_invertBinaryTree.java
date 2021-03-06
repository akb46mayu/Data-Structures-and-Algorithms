/* Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursion witnout return values
public class Solution {
    public TreeNode invertTree(TreeNode root) {
       invertHelper(root);
       return root;
    }
    private void invertHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertHelper(root.left);
        invertHelper(root.right);
    }
}

///   recursion with return values
public class Solution {
    public TreeNode invertTree(TreeNode root) {
       if (root == null || (root.left == null && root.right == null)) {
            return root;
        } else {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            return root;
        }
    }   
}
