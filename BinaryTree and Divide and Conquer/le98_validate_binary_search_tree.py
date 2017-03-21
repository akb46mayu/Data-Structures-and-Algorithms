"""
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
    
        return self.isValidBSTHelper(root, float('-inf'),float('inf'))
    def isValidBSTHelper(self, root, minv, maxv):
        if root is None:
            return True
        return root.val> minv and root.val<maxv and self.isValidBSTHelper(root.left, minv, root.val) and self.isValidBSTHelper(root.right, root.val, maxv)

    
class Solution2: # divide and conquer
    """
    @param root: The root of binary tree.
    @return: True if the binary tree is BST, or false
    """  
    def isValidBST(self, root):
        # write your code here
        
        if not root:
            return True
        ans, _ , _ = self.bstHelper(root)
        return ans
        
    def bstHelper(self, root):  # for the current tree with the current node, return isBool, minval of the tree and maxval
        if not root:
            return  True, sys.maxint, -sys.maxint # isbst, min, max
        isBSTL, minleft, maxleft = self.bstHelper(root.left)
        isBSTR, minright, maxright = self.bstHelper(root.right)
        
        if not isBSTL or not isBSTR:
            return False, 0, 0
        if (root.left and root.val <= maxleft) or (root.right and root.val >= minright):
            return False, 0, 0
        return True, min(root.val, minleft), max(root.val, maxright)
