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
  public boolean isCompleted(TreeNode root) {
    // Write your solution here.
      if (root == null) {
        return true;
      }
      boolean tag = false;
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.offer(root);
      while (!q.isEmpty()) {
        TreeNode cur = q.poll();
        if (cur.left == null) {
          tag = true;
        } else if (tag) {
          return false;
        } else {
          q.offer(cur.left);
        }
        if (cur.right == null) {
          tag = true;
        } else if (tag) {
          return false;
        } else {
          q.offer(cur.right);
        }
    }
    return true;
  }
}
