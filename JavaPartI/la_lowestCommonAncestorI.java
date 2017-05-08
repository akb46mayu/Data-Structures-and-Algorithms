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
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // Write your solution here.
    if (root == null || root == one || root == two) {
      return root;
    }
    TreeNode lnode = lowestCommonAncestor(root.left, one, two);
    TreeNode rnode = lowestCommonAncestor(root.right, one, two);
    if (lnode != null && rnode != null) {
      return root;
    }
    return lnode == null ? rnode : lnode;
  }
}
