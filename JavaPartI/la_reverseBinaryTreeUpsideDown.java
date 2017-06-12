/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode reverse(TreeNode root) {
    // Write your solution here.
    if (root == null || root.left == null) {
      return root;
    }
    TreeNode newroot = reverse(root.left);
    root.left.left = root;
    root.left.right = root.right;
    root.left = null;
    root.right = null;
    return newroot;
  }
}
