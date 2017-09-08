
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
  public TreeNode reconstruct(int[] pre) {
    // Write your solution here.
    int[] idx = {0};
    return reconstruct(pre, idx, Integer.MAX_VALUE);
  }
  
  private TreeNode reconstruct(int[] pre, int[] idx, int min) {
    int n = pre.length;
    if (idx[0] >= n || pre[idx[0]] >= min ) {
      return null;
    }
    int val = pre[idx[0]];
    TreeNode node = new TreeNode(val);
    idx[0]++;
    node.left = reconstruct(pre, idx, val);
    node.right = reconstruct(pre, idx, min);
    return node;
  }
}
