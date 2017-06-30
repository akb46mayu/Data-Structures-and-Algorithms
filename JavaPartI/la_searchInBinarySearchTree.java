
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
public class Solution {  // recursion
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here.
    if (root == null) {
      return null;
    }
    if (root.key == key) {
      return root;
    } else if (root.key < key) {
      return search(root.right, key);
    } else {
      return search(root.left, key);
    }
  }
}

////////
public class Solution2 { // non recursion
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here.
    if (root == null) {
      return root;
    }
    TreeNode cur = root;
    while(cur != null) {
      if (cur.key == key) {
        return cur;
      } else if (cur.key < key) {
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }
    return cur;
  }
}
