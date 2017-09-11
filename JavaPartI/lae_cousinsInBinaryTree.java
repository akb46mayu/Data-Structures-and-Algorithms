
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
  public boolean isCousin(TreeNode root, int a, int b) {
    // Write your solution here.
    boolean[] tag = {false};
    depth(root, 0, a, b, tag);
    return tag[0];
  }
  
  private int depth(TreeNode root, int level, int a, int b, boolean[] tag) {
    if (root == null) {
      return -1;
    }
    if (root.key == a || root.key == b) {
      return level;
    }
    int left = depth(root.left, level + 1, a, b, tag);
    int right = depth(root.right, level + 1, a, b, tag);
    if (left == right && left - level > 1) {
      tag[0] = true;
    }
    return left > right ? left : right;
  }
}
