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
/// iteration way 1
public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    if (root == null) {
      return result;
    }
    TreeNode cur = root;
    while (cur!=null || !stack.isEmpty()) {
      if (cur!=null) {
        stack.offerFirst(cur);
        cur = cur.left;
      } else {
        cur = stack.pollFirst();
        result.add(cur.key);
        cur = cur.right;
      }
    }
    return result;
  }
}
///// iteration way 2
public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here.
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> res = new ArrayList<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()){
      while (cur != null) {
        stack.offerFirst(cur);
        cur = cur.left;
      }
      cur = stack.peekFirst().right;
      res.add(stack.pollFirst().key);
    }
    return res;
  }
}


///////

public class Solution2 {  //recursion + divide conquer type
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
     return result; 
    }
    List<Integer> left = inOrder(root.left);
    result.addAll(left);
    result.add(root.key);
    List<Integer> right = inOrder(root.right);
    result.addAll(right);
    return result;
  }
}
