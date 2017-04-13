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
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    postOrderHelper(root, result);
    return result;
  }
  
  public void postOrderHelper(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    postOrderHelper(root.left, result);
    postOrderHelper(root.right, result);
    result.add(root.key);
  }
}


public class Solution2 { // non recursion
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    if (root == null) {
      return result;
    }
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      result.add(cur.key);
      if (cur.left != null) {
        stack.offerFirst(cur.left);
      } 
      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
    }
    Collections.reverse(result);
    return result;
  }
}
