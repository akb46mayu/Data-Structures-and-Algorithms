
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
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here.
    if (root == null) {
      return null;
    }
    if (root.key == key) {
      return root;
    } else if (root.key < key) {
      return search(root.right, key);
    } else {
      return search(root.left, key);
    }
  }
}
