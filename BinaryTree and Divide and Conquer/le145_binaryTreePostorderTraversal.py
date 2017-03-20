"""
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        ans = []
        self.postorderHelper(root, ans)
        return ans
        
    def postorderHelper(self, root, ans):
        if not root:
            return
        self.postorderHelper(root.left, ans)
        self.postorderHelper(root.right, ans)
        ans.append(root.val)
      
class Solution2(object): # non recursion
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        ans = []
        stack = [(root, False)]
        while stack:
            popEle, isVisited = stack.pop()
            if popEle is None:
                continue
                
            if isVisited == True:
                ans.append(popEle.val)
            else:
                stack.append((popEle, True))
                stack.append((popEle.right, False))
                stack.append((popEle.left, False))
        return ans
