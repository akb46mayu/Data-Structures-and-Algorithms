/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    int numone = numNodes(one);
    int numtwo = numNodes(two);
    if (numone > numtwo) {
      return lca(two, one, numone - numtwo);
    } else {
      return lca(one, two, numtwo - numone);
    }
  }
  
  private TreeNodeP lca(TreeNodeP shorter, TreeNodeP longer, int diff) {
    while(diff > 0) {
      longer = longer.parent;
      diff--;
    }
    while(shorter != longer) {
      shorter = shorter.parent;
      longer = longer.parent;
    }
    return shorter;
  }
  
  private int numNodes(TreeNodeP p) {
    int num = 0;
    while(p != null) {
      num++;
      p = p.parent;
    }
    return num;
  }
}
