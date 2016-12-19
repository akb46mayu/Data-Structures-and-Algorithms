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
