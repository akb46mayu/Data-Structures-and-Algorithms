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
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    if (root == null){
      return result;
    }
    List<Integer> left = preOrder(root.left);
    List<Integer> right = preOrder(root.right);
    result.add(root.key);
    result.addAll(left);
    result.addAll(right);
    return result;
    
  }
}
