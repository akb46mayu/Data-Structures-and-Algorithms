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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    rangeHelper(root, min, max, result);
    return result;
  }
  
  private void rangeHelper(TreeNode root, int min, int max, List<Integer> result) {
    if (root == null) {
      return;
    }
    rangeHelper(root.left, min, max, result);
    if (root.key <= max && root.key >= min ) {
      result.add(root.key);
    }
    rangeHelper(root.right, min, max, result);
  }
}
