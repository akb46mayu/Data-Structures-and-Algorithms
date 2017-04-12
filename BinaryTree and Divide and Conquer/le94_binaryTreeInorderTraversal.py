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
      

