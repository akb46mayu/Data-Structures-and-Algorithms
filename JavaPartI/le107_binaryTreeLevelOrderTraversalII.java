/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int qsize = q.size();
            List<Integer> alist = new LinkedList<>();
            for (int i = 0; i < qsize; i++) {
                TreeNode temp = q.poll();
                alist.add(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);    
                } 
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            res.add(0, alist);
        }
        return res;
    }
}
//// dfs
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level + 1> res.size()) {
            res.add(0, new LinkedList<Integer>());
        }
        res.get(res.size() - level - 1).add(root.val);
        
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}
