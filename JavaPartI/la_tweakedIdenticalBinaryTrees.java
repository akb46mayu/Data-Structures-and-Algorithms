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
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    // Write your solution here.
    if (one == null && two == null) {
      return true;
    } else if (one!=null && two!= null) {
      boolean c1 = isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
      boolean c2 = isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
      return one.key == two.key && (c1 || c2);
    } else {
      return false;
    }
  }
}
