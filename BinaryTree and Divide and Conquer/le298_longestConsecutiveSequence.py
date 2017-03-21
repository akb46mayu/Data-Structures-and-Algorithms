"""
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.


"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def longestConsecutive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        self.maxval = -sys.maxint
        self.longHelper(root)
        return self.maxval
        
    def longHelper(self, root):  # for all the paths from cur root to any leafs, the longest path including the cur root node
        if not root:
            return 0
        
        leftmax = self.longHelper(root.left)
        rightmax = self.longHelper(root.right)
        curmax = 1
        
        if root.left and root.val + 1 == root.left.val: 
            curmax = max(curmax, leftmax + 1)
        if root.right and root.val + 1 == root.right.val:
            curmax = max(curmax, rightmax + 1)
        self.maxval = max(curmax, self.maxval, leftmax, rightmax)
        return curmax
        
  class Solution2(object):
    def longestConsecutive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        return self.longHelper(root, None, 0)
        
    def longHelper(self, root, parent, lengthprev):
        if not root:
            return 0
        if parent and parent.val + 1 == root.val:
            length = lengthprev + 1 
        else:
            length = 1
        
        
        leftlength = self.longHelper(root.left, root, length)
        rightlength = self.longHelper(root.right, root, length)
        return max(leftlength, rightlength, length)
