"""

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object): # recursion
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        ans = []
        self.inorderHelper(root, ans)
        return ans
        
        
    def inorderHelper(self, root, ans):
        if not root:
            return
        self.inorderHelper(root.left, ans)
        ans.append(root.val)
        self.inorderHelper(root.right, ans)


class Solution2(object): # non-recursion
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        ans = []
        stack = [root]
        while 1:
            if stack[-1].left:
               stack.append(stack[-1].left)
            else:
                break
        while stack:
            popEle = stack.pop()
            ans.append(popEle.val)
            if popEle.right:
                stack.append(popEle.right)
                while 1:
                    if stack[-1].left:
                       stack.append(stack[-1].left)
                    else:
                        break
        return ans      
      
### JAVA---------------------
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
