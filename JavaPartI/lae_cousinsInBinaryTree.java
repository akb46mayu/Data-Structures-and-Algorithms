
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
  public boolean isCousin(TreeNode root, int a, int b) {
    // Write your solution here.
    boolean[] tag = {false};
    depth(root, 0, a, b, tag);
    return tag[0];
  }
  
  private int depth(TreeNode root, int level, int a, int b, boolean[] tag) {
    if (root == null) {
      return -1;
    }
    if (root.key == a || root.key == b) {
      return level;
    }
    int left = depth(root.left, level + 1, a, b, tag);
    int right = depth(root.right, level + 1, a, b, tag);
    if (left == right && left - level > 1) {
      tag[0] = true;
    }
    return left > right ? left : right;
  }
}
// bfs

public class Solution2 {
  public boolean isCousin(TreeNode root, int a, int b) {
    // Write your solution here.
    if (root == null || root.key == a || root.key == b) {
      return false;
    }
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode paren1 = null, paren2 = null;
    q.offer(root);
    while (!q.isEmpty()) {
      int qsize = q.size();
      for (int i = 0; i < qsize; i++) {
        TreeNode temp = q.poll();
        if (temp.left != null) {
          if (temp.left.key == a) {
            paren1 = temp;
          } else if (temp.left.key == b) {
            paren2 = temp;
          }
          q.offer(temp.left);
        }
        if (temp.right != null) {
          if (temp.right.key == a) {
            paren1 = temp;
          } else if (temp.right.key == b) {
            paren2 = temp;
          }
          q.offer(temp.right);
        }
      }
      if (paren1 != null && paren2 != null && paren1 != paren2) {
        return true;
      } else {
        paren1 = null;
        paren2 = null;
      }
    }
    return false;
  }
}
