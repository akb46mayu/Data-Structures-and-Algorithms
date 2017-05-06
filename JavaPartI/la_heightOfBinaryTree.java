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
   public int findHeight(TreeNode root) {
     // Write your solution here.
     if (root == null) {
       return 0;
     }
     int lefth = findHeight(root.left);
     int righth = findHeight(root.right);
     return Math.max(lefth, righth) + 1;
   }
}
