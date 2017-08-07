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
// post order traversal
public class Solution {
  public boolean isBalanced(TreeNode root) {
    // Write your solution here.
    
    return balanceHelper(root) >= 0;
  }
  private int balanceHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = balanceHelper(root.left);
    int right = balanceHelper(root.right);
    if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
      return 1 + Math.max(left, right);
    }
    return -1;
  }
}
/// way 2:
public class Solution {
  public boolean isBalanced(TreeNode root) {
    // Write your solution here.
    return checkBalance(root) != -1;
  }
  
  private int checkBalance(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = checkBalance(root.left);
    int right = checkBalance(root.right);
    if (left == -1 || right == -1) {
      return -1;
    }
    return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
  }
 
}
