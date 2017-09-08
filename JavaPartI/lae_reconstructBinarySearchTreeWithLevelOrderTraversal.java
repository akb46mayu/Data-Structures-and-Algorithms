
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
  public TreeNode reconstruct(int[] level) {
    // Write your solution here.
    List<Integer> list = new ArrayList<>();
    for (int i : level) {
      list.add(i);
    }
    return reconHelper(list);
  }
  
  private TreeNode reconHelper(List<Integer> list) {
    if (list.size() == 0) {
      return null;
    }
    int rootval = list.get(0);
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    TreeNode root = new TreeNode(rootval);
    for (int i = 1; i < list.size(); i++) {
      int val = list.get(i);
      if (val < rootval) {
        left.add(val);
      } else {
        right.add(val);
      }
    }
    root.left = reconHelper(left);
    root.right = reconHelper(right);
    return root;
  }
}
