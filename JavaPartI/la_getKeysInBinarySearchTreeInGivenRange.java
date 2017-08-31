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

//// solution two with cutting branches
public class Solution {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Write your solution here.
    List<Integer> res = new ArrayList<>();
    rangeHelper(root, min, max, res);
    return res;
  }
  
  private void rangeHelper(TreeNode root, int min, int max, List<Integer> res) {
    if (root == null) {
      return;
    }
    if (root.key > min) {
      rangeHelper(root.left, min, max, res);
    }
    if (root.key >= min && root.key <= max) {
      res.add(root.key);
    }
    if (root.key < max) {
      rangeHelper(root.right, min, max, res);
    }
  }
}
