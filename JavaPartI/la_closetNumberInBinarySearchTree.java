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
public class Solution1 {  // my method using recursion
  public int closest(TreeNode root, int target) {
    // Write your solution here.
    int[] res = {Integer.MAX_VALUE};
    closeHelper(root, target, res);
    return res[0];
  }
  private void closeHelper(TreeNode root, int target, int[] res) {
    if (root == null) {
      return;
    }
    if (root.key == target) {
      res[0] = target;
      return;
    }
    if (root.key < target) {
      closeHelper(root.right, target, res);
    } else {
      closeHelper(root.left, target, res);
    }
    if (Math.abs(res[0] - target) > Math.abs(root.key - target)) {
       res[0] = root.key;
    }
  }
}
