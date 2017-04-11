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
  public boolean isBST(TreeNode root) {
    // Write your solution here.
    return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  private boolean isBSTHelper(TreeNode root, int minval, int maxval) {
    if (root == null) {
      return true;
    }
    boolean left = isBSTHelper(root.left, minval, root.key);
    boolean right = isBSTHelper(root.right, root.key, maxval);
    return left && right && (root.key < maxval && root.key > minval);
  }
  
}
