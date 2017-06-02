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
  public List<Integer> zigZag(TreeNode root) {
    // Write your solution here.
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }
    Deque<TreeNode> dq = new LinkedList<>();
    dq.offerFirst(root);
    TreeNode cur = root;
    int i = 1;
    while (!dq.isEmpty()) {
      int dqsize = dq.size();
      if (i % 2 == 1) {
        for (int j = 0; j < dqsize; j++) {
          cur = dq.pollFirst();
          res.add(cur.key);
          if (cur.right != null) {
            dq.offerLast(cur.right);
          }
          if (cur.left != null) {
            dq.offerLast(cur.left);
          }
        }
      } else {
        for (int j = 0; j < dqsize; j++) {
          cur = dq.pollLast();
          res.add(cur.key);
          if (cur.left != null) {
            dq.offerFirst(cur.left);
          }
          if (cur.right != null) {
            dq.offerFirst(cur.right);
          }
        }
      }
      i++;
    }
    return res;
  }
}
