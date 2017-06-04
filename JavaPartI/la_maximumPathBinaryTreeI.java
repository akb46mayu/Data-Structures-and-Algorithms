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
    int[] maxval = {Integer.MIN_VALUE};
    doMaxPathSum(root, maxval);
    return maxval[0];
  }
  
  private int doMaxPathSum(TreeNode root, int[] maxval) {
    if (root == null) {
      return 0;
    }
    int leftSum = doMaxPathSum(root.left, maxval);
    int rightSum = doMaxPathSum(root.right, maxval);
    int totalSum = leftSum + rightSum + root.key;
    if (root.left != null && root.right != null) {
      maxval[0] = Math.max(maxval[0], totalSum);
      return Math.max(leftSum, rightSum) + root.key;
    }
    return root.left == null ? rightSum + root.key : leftSum + root.key;
  }
}
