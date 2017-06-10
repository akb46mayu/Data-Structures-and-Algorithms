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
  public TreeNode reconstruct(int[] in, int[] level) {
    // Write your solution here.
    Map<Integer, Integer> hmap = new HashMap<>();
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < in.length; i++) {
      hmap.put(in[i], i);
      list.add(level[i]);
    }
    return reconSub(hmap, list);
    
  }
  
  private TreeNode reconSub(Map<Integer, Integer> hmap, List<Integer> list) {
    if (list.isEmpty()) {
      return null;
    }
    TreeNode root = new TreeNode(list.remove(0));
    int rootidx = hmap.get(root.key);
    List<Integer> llist = new ArrayList<>(); 
    List<Integer> rlist = new ArrayList<>(); 
    for (int ele : list) {
      if (hmap.get(ele) < rootidx) {
        llist.add(ele);
      } else {
        rlist.add(ele);
      }
    }
    root.left = reconSub(hmap, llist);
    root.right = reconSub(hmap, rlist);
    return root;
  }
  
}
