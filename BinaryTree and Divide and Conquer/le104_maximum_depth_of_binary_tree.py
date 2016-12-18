# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """        
        if root == None:
            return 0
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

class Solution2(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.maxDepthCount(root)
        
    def maxDepthCount(self, root):
        if root == None:
            return 0
        l = self.maxDepthCount(root.left)
        r = self.maxDepthCount(root.right)
        return 1 + max(l, r)
