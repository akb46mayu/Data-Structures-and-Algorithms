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
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    if (root == null){
      return result;
    }
    List<Integer> left = preOrder(root.left);
    List<Integer> right = preOrder(root.right);
    result.add(root.key);
    result.addAll(left);
    result.addAll(right);
    return result;
    
  }
}



public class Solution2 {  // non - recursion
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    
    while (!stack.empty()) {
      TreeNode curnode = stack.pop();
      result.add(curnode.key);
      if (curnode.right != null) {
        stack.push(curnode.right);
      }
      if (curnode.left != null) {
        stack.push(curnode.left);
      }
    }
    return result;
  }
