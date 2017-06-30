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
  public TreeNode delete(TreeNode root, int key) {
    // Write your solution here.
    if (root == null) {
      return null;
    } 
    if (root.key < key) {
      root.right = delete(root.right, key);
    } else if (root.key > key) {
      root.left = delete(root.left, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null || root.right == null) {
        return root.left == null ? root.right : root.left;
      } else {
        TreeNode rightSmallest = findSmallest(root.right);
        root.key = rightSmallest.key;
        root.right = delete(root.right, root.key);
      }
    }
    return root;
  }
  private TreeNode findSmallest(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}
////// the other way of using findsmallest

private TreeNode findSmallest(TreeNode root) {
    TreeNode par = root;
    while(root != null) {
      par = root;
      root = root.left;
    }
    return par;
  }  
