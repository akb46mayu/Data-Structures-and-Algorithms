

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode popnode = root;
        while (popnode!=null || !stack.empty()){
          while (popnode!=null){
            stack.add(popnode);
            popnode = popnode.left;
          }
          popnode = stack.peek();  // record the referene before poping
          stack.pop();
          result.add(popnode.val);
          popnode = popnode.right;
          
        }
        return result;
    }
}
