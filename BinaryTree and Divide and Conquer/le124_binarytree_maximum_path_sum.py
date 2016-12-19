# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        result, _ = self.maxPathSumHelper(root)
        return result
        
    def maxPathSumHelper(self, root):
        if root is None:
            return -sys.maxint, 0
        
        left = self.maxPathSumHelper(root.left)
        right = self.maxPathSumHelper(root.right)
        
        globalmax = max(left[0], right[0], left[1] + right[1] + root.val)
        localmax = max(left[1] + root.val, right[1] + root.val, 0)
        return globalmax, localmax
