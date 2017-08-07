
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
  public int diameter(TreeNode root) {
    // Write your solution here.
    int[] glbmax = {0};
    getDia(root, glbmax);
    return glbmax[0];
  }
  
  private int getDia(TreeNode root, int[] glbmax) {
    if (root == null) {
      return 0;
    }
    int left = getDia(root.left, glbmax);
    int right = getDia(root.right, glbmax);
    int sum = left + right + 1;
    if (root.left != null && root.right != null) {
      if (sum > glbmax[0]) {
        glbmax[0] = sum;
      }
      return Math.max(left, right) + 1;
    } 
    return root.left != null ? 1 + left : 1 + right;
  }
  
}
