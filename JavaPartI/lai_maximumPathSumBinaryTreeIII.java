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
    int presum = 0;
    int[] globalmax = {Integer.MIN_VALUE};
    maxSubSum(root, presum, globalmax);
    return globalmax[0];
  }
  
  private void maxSubSum(TreeNode root, int presum, int[] globalmax) {
    if (root == null) {
      return;
    }
    if (presum < 0) {
      presum = root.key;
    } else {
      presum += root.key;
    }
    globalmax[0] = Math.max(globalmax[0], presum);
    maxSubSum(root.left, presum, globalmax);
    maxSubSum(root.right, presum, globalmax);
  }
}
