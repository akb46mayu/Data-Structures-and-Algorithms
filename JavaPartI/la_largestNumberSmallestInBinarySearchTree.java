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
  public int largestSmaller(TreeNode root, int target) {
    // Write your solution here.
    int res = Integer.MIN_VALUE;
    while (root != null) {
      if (target > root.key) {
        res = root.key;
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return res;
  }
}
