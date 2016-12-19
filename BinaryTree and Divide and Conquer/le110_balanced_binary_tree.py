# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        result = [True]
        self.subIsBalanced(root, result)
        return result[0]
        
    def subIsBalanced(self, root, result):
        if root is None:
            return 0
        a1 = self.subIsBalanced(root.left, result)
        a2 = self.subIsBalanced(root.right, result)
        k = abs(a1 - a2)
        if k > 1:
            result[0] = False
        return max(a1,a2) + 1
    
class Solution2(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        isBalanced, valof = self.isNodeBalanced(root)
        return isBalanced
        
    def isNodeBalanced(self, root):
        if root is None:
            return True, 0
        
        isBalanced, leftval = self.isNodeBalanced(root.left)
        if not isBalanced:
            return False, 0
        isBalanced, rightval = self.isNodeBalanced(root.right)
        if not isBalanced:
            return False, 0
        return abs(leftval - rightval)<=1, max(leftval, rightval) + 1
        
