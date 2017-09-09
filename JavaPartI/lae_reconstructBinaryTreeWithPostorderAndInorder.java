
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
  public TreeNode reconstruct(int[] in, int[] post) {
    // Write your solution here.
    Map<Integer, Integer> hmap = getMap(in);
    int n = in.length;
    return reconHelper(in, 0, n - 1, post, 0, n - 1, hmap);
  }
  
  private TreeNode reconHelper(int[] in, int inl, int inr, 
                               int[] po, int pol, int por, Map<Integer, Integer> hmap) {
    if (pol > por) {
      return null;
    }
    TreeNode node = new TreeNode(po[por]);
    int idx = hmap.get(node.key);
    int leftlen = idx - inl, rightlen = inr - idx;
    node.right = reconHelper(in, idx + 1, idx + rightlen, po, por - rightlen, por - 1, hmap);
    node.left = reconHelper(in, inl, idx - 1, po, pol, pol + leftlen - 1, hmap);
    return node;
  }
  
  private Map<Integer, Integer> getMap(int[] in) {
    Map<Integer, Integer> hmap = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      hmap.put(in[i], i);
    }
    return hmap;
  }
}
