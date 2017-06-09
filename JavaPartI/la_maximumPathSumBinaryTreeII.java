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
  public int maxPathSum(TreeNode root) {
    // Write your solution here.
    int[] globalmax = {Integer.MIN_VALUE};
    maxSubSum(root, globalmax);
    return globalmax[0];
  }
  
  private int maxSubSum(TreeNode root, int[] globalmax) {
    if (root == null) {
      return 0;
    }
    int sumLeft = maxSubSum(root.left, globalmax);
    int sumRight = maxSubSum(root.right, globalmax);
    globalmax[0] = Math.max(globalmax[0], sumLeft + sumRight + root.key);
    return Math.max(0, root.key + Math.max(sumLeft, sumRight)); // make the return value always positive
  }
}
