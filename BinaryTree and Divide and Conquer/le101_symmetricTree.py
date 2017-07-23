# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        return self.symHelper(root.left, root.right)
    
    def symHelper(self, one, two):
        if one == None and two == None:
            return True
        elif one == None or two == None:
            return False
        else:
            if one.val == two.val:
                return self.symHelper(one.left, two. right) and self.symHelper(one.right, two.left)
            else:
                return False
