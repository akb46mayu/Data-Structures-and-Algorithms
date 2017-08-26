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
  public boolean isSymmetric(TreeNode root) {
    // Write your solution here.
    if (root == null) {
      return true;
    }
    return symHelper(root.left, root.right);
  }
  
  private boolean symHelper(TreeNode one, TreeNode two) {
     if (one == null && two == null) {
       return true;
     } else if (one!= null && two!= null) {
       return one.key == two.key && symHelper(one.left, two.right) && symHelper(one.right, two.left);
     } else {
       return false;
     }
    
  }
}
