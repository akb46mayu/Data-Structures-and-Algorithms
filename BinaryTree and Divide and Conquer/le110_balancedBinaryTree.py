"""

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# when no nodes, height is 0. one node, heigt is 1
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
###
class Solution(object):  # lai java converted
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.balanceHelper(root) >= 0
    def balanceHelper(self, root):
        if root == None:
            return 0
        left = self.balanceHelper(root.left)
        right = self.balanceHelper(root.right)
        if left == - 1 or right == -1:
            return -1
        return -1 if abs(left - right) > 1 else max(left, right) + 1


###
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
        
