"""
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

 Notice

node A or node B may not exist in tree.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

"""

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
import copy
class Solution:
    """
    @param {TreeNode} root The root of the binary tree.
    @param {TreeNode} A and {TreeNode} B two nodes
    @return Return the LCA of the two nodes.
    """ 
    def lowestCommonAncestor3(self, root, A, B):
        # write your code here
        if not root:
            return None
        foundA, foundB, ans = self.lcaHelper(root, A, B)
        if foundA and foundB:
            return ans
        return None

    def lcaHelper(self, root, A, B):
        if root is None:
            return False, False, None

        
        foundAL, foundBL, left = self.lcaHelper(root.left, A, B)
        foundAR, foundBR, right = self.lcaHelper(root.right, A, B)
        
        foundA = foundAL or foundAR or root == A
        foundB = foundBL or foundBR or root == B
        if root == A or root == B: # this is used when A==B?
            return foundA, foundB, root
        if left and right:
            return foundA, foundB, root
        if left:
            return foundA, foundB, left
        if right:
            return foundA, foundB, right
        return foundA, foundB, None
