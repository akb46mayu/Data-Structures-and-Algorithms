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
/// way 2: (return value is void)
public class Solution {
  public boolean exist(TreeNode root, int target) {
    // Write your solution here.
    boolean[] res = {false};
    Set<Integer> hset = new HashSet<>();
    hset.add(0);
    checkSol(root, res, 0, hset, target);
    return res[0];
  }
  
  private void checkSol(TreeNode root, boolean[] res, int prevsum, Set<Integer> hset, int target) {
    if (root == null) {
      return;
    }
    int cursum = prevsum + root.key;
    if (hset.contains(cursum - target)) {
      res[0] = true;
      return;
    }
    boolean newval = hset.add(cursum);
    checkSol(root.left, res, cursum, hset, target);
    checkSol(root.right, res, cursum, hset, target);
    if (newval) {
      hset.remove(cursum);
    }
    return;
  }
}
