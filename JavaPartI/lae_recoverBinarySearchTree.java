
public class Solution {
  TreeNode one;
  TreeNode two;
  TreeNode prev = new TreeNode(Integer.MIN_VALUE);
  public TreeNode recover(TreeNode root) {
    // Write your solution here.
    recoverHelper(root);
    int temp = one.key;
    one.key = two.key;
    two.key = temp;
    return root;
  }
  
  private void recoverHelper(TreeNode root) {
    if (root == null) {
      return;
    }
    recoverHelper(root.left);
    if (one == null && prev.key >= root.key) {
      one = prev;
    }
    if (one != null && prev.key >= root.key) {
      two = root;
    }
    prev = root;
    recoverHelper(root.right);
  }
}
