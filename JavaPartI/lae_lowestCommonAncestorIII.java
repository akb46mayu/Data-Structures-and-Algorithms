
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // write your solution here
    TreeNode res = lcaHelper(root, one, two);
    if (res == null) {
      return null;
    } else if (res == one) {
      return checkExist(root, two) ? one : null;
    } else if (res == two) {
      return checkExist(root, one) ? two : null;
    } else {
      return res;
    }
  }
  
  private TreeNode lcaHelper(TreeNode root,
      TreeNode one, TreeNode two) {
    if (root == null || root == one || root == two) {
      return root;
    }
    
    TreeNode left = lcaHelper(root.left, one, two);
    TreeNode right = lcaHelper(root.right, one, two);
    if (left != null && right != null) {
      return root;
    } 
    return left != null ? left : right;
  }
  private  boolean checkExist(TreeNode root, TreeNode tar) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode temp = q.poll();
      if (temp == tar) {
        return true;
      }
      if (temp.left != null) {
        q.offer(temp.left);
      }
      if (temp.right != null) {
        q.offer(temp.right);
      }
    }
    return false;
  }
}
