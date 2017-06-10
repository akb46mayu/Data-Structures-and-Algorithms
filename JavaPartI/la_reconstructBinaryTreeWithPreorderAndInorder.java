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
  public TreeNode reconstruct(int[] in, int[] pre) {
    // Write your solution here.
    Map<Integer, Integer> hmap = genInHash(in);
    return reconSub(in, 0, in.length - 1, pre, 0, pre.length - 1, hmap);
  }
  
  private TreeNode reconSub(int[] in, int in_l, int in_r, 
                            int[] pre, int pre_l, int pre_r, 
                            Map<Integer, Integer> hmap) {
    if (in_l > in_r) {
      return null;
    }             
    TreeNode root = new TreeNode(pre[pre_l]);
    int leftsize = hmap.get(root.key) - in_l;
    root.left = reconSub(in, in_l, in_l + leftsize - 1, pre, pre_l + 1, pre_l + leftsize, hmap);
    root.right = reconSub(in, in_l + leftsize + 1, in_r, pre, pre_l + leftsize + 1, pre_r, hmap);
    return root;
  }
  
  private Map<Integer, Integer> genInHash(int[] in) {
    Map<Integer, Integer> hmap = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      hmap.put(in[i], i);
    }
    return hmap;
  }

}
