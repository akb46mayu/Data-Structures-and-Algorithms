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
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    postOrderHelper(root, result);
    return result;
  }
  
  public void postOrderHelper(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    postOrderHelper(root.left, result);
    postOrderHelper(root.right, result);
    result.add(root.key);
  }
}
