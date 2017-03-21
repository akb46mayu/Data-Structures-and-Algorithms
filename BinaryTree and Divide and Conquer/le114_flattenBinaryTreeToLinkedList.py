"""
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6


"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.lastNode = None
        self.dfsHelper(root)

        
    def dfsHelper(self, root): # i am not familiar with this case when reference is a node not a list/dict
        if not root:
            return
        if self.lastNode:
            self.lastNode.left = None
            self.lastNode.right = root
        self.lastNode = root
        right = root.right
        self.dfsHelper(root.left) # after this step root's location (direction) has been changed
        self.dfsHelper(right)
