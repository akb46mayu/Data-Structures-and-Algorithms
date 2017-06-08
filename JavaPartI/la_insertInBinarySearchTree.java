
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
  public TreeNode insert(TreeNode root, int key) {
    // Write your solution here.
    if (root == null) {
      root = new TreeNode(key);
      return root;
    }
    TreeNode cur = root, par = root;
    while (cur != null) {
      par = cur;
      if (cur.key == key) {
        return root;
      }
      if (key < cur.key) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    
    if (key < par.key) {
      par.left = new TreeNode(key);
    } else {
      par.right = new TreeNode(key);
    }
    
    return root;
  }
}
