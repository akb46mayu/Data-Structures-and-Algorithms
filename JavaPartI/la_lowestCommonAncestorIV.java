public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    // Write your solution here. 
    
    Set<TreeNode> hset = new HashSet<TreeNode>(nodes);
    return lca(root, hset);
  }
  
  private TreeNode lca(TreeNode root, Set<TreeNode> hset) {
    if (root == null) {
      return null;
    }
    if(hset.contains(root)) {
      return root;
    }
    TreeNode l = lca(root.left, hset);
    TreeNode r = lca(root.right, hset);
    if (l != null && r != null) {
      return root;
    }
    return l != null ? l : r;
    
  }
}
