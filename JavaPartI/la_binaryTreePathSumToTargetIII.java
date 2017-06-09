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
  public boolean exist(TreeNode root, int target) {
    // Write your solution here.
    Set<Integer> hset = new HashSet<>();
    hset.add(0);
    return existPath(root, target, hset, 0);
  }
  
  private boolean existPath(TreeNode root, int target, Set<Integer> hset, int prevsum) {
    if (root == null) {
      return false;
    }
    prevsum += root.key;
    if (hset.contains(prevsum - target)) {
      return true;
    }
    boolean newval = hset.add(prevsum);
    if (existPath(root.left, target, hset, prevsum)) {
      return true;
    }
    if (existPath(root.right, target, hset, prevsum)) {
      return true;
    }
    if (newval) {
      hset.remove(prevsum);
    }
    return false;
  }
}
