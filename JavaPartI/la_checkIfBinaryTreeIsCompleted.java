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
      Queue<TreeNode> q = new LinkedList<>();
      int tag = 0;
      q.offer(root);
      while(!q.isEmpty()) {
        int qsize = q.size();
        for (int i = 0; i < qsize; i++) {
          TreeNode temp = q.poll();
          if (temp.left != null) {
            if (tag == 1) {
              return false;
            }
            q.offer(temp.left);
          } else {
            tag = 1;
          }
          if (temp.right != null) {
            if (tag == 1) {
              return false;
            }
            q.offer(temp.right);
          } else {
            tag = 1;
          }
        }
      }
      return true;
  }
}
